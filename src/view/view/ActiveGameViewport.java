package view.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

import controller.RunGame;
import model.entities.Avatar;
import model.entities.Entity;
import model.loadsave.FilePaths;
import model.loadsave.Load;
import model.map.Tile;
import utilities.TileAlgorithm;
import view.modelview.tile.TileView;
import view.modelview.tileable.TileableView;
import view.tools.Constants;
import view.tools.ImagePaths;

@SuppressWarnings("serial")
public class ActiveGameViewport extends Viewport {
	
	// note for tomorrow (and adam)....
	//
	// the activeGameViewport has way too much logic in it! this should
	// mainly be in controller. for instance, this one. absolutely this one.
	// i think the best course of action might be to have corresponding
	// "controller" classes for every view. each of these has a reference to its view.
	//
	// for example, "ActiveGameController" would have the functionality for
	// creating the map and for instantiating an avatar. then it feeds both these things into 
	// the constructor of "ActiveGameViewport." 
	//
	// - danny
	
	Tile currentTile;
	Tile scrollableTile;
	Tile avatarTile;
	boolean scrolling = false;
	int livesLeft = 3;
	
	Load load = new Load();
	
	private static ActiveGameViewport activeGameViewport = 
			new ActiveGameViewport();

	public ActiveGameViewport() {
		this.setPreferredSize(ViewFrame.getInstance().getSize());
		this.setBackground(new Color(44,62,80));                
                
		// get beginning tile
		try {load.read(FilePaths.DEFAULT);} 
		catch (IOException e) {e.printStackTrace();}
		currentTile = load.getBeginningTile();
		avatarTile = currentTile;
		scrollableTile = currentTile;
		
		Entity avatar = new Avatar(currentTile);
		this.addAvatarKeyBinding(((Avatar) avatar).getKeyBinding());
		this.setFocusable(true);
	}
	
	@Override
	public void visit(ViewportStack viewportStack) {
		ViewportStack.add(this);
	}
	
	public static ActiveGameViewport getInstance() {
		return activeGameViewport;
	}

	// --------------
	// THE ACTUAL PAINT FUNCTION
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		List<Tile> tiles = TileAlgorithm.getAllTiles(currentTile);
		
		drawMap(g, tiles);
		drawMiniMap(g, tiles);
		drawLivesLeft(g);
		drawSimpleStats(g);
	}
	// ----------------
	
	public void drawMap(Graphics g, List<Tile> tiles) {
		Tile start = currentTile;
		Point pixels = TileAlgorithm.toPixel(start);
		
		int dx = this.getWidth() / 2 - pixels.x;
		int dy = this.getHeight() / 2 - pixels.y;
		
		Point p;
		for (Tile t : tiles) {
			p = TileAlgorithm.toPixel(t);
			TileView tileView = t.getTileView();
			if(tileView.hasBeenSeen()){
				if (!this.isScrolling()) tileView.incrementAge();
				g.drawImage(tileView.getImage(), p.x + dx, p.y + dy, 
					Constants.TILE_HEIGHT, Constants.TILE_WIDTH, null);
			}
		}
	}
	
	public void drawMiniMap(Graphics g, List<Tile> tiles) {
		Tile start = currentTile;
		Point p, pixels = TileAlgorithm.toPixel(start);
		
		int dx = this.getWidth() / 2 - pixels.x;
		int dy = this.getHeight() / 2 - pixels.y;
		
		// draw box
		g.setColor(new Color(241,196,15,100));
		int xStart = ViewFrame.getInstance().getWidth() - 160;
			// FIX THIS. LATER.
			// LAW OF DEMETER :'(
		
		
		g.fillRect(xStart, 10, Constants.GAME_VIEW_WIDTH / 10 + 90, Constants.GAME_VIEW_HEIGHT / 10 + 85);
		
		// draw map
		for (Tile t : tiles) {
			p = TileAlgorithm.toPixel(t);
			TileView miniTileView = t.getTileView();
			if(miniTileView.hasBeenSeen()){
				if (!this.isScrolling()) miniTileView.incrementAge();
				g.drawImage(miniTileView.getImage(), (p.x / 10) + xStart + 15, (p.y / 10) + 20, 
					Constants.MINI_TILE_HEIGHT, Constants.MINI_TILE_WIDTH, null);
			}
		}
	}
	
	public void drawLivesLeft(Graphics g) {
		Color c = Color.pink;
		g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 100));
		
		int height = Constants.GAME_VIEW_HEIGHT / 15 - 15,
			width  = Constants.GAME_VIEW_WIDTH / 10 + 30;
		
		g.fillRect(10, 10, width - 15, height );
		
		// for text
		g.setColor(Color.BLACK);
		
		try { 
			BufferedImage heart = ImageIO.read(new File(ImagePaths.HEART));
			g.drawImage(heart, 20, 20, width  / 4, height - 15, null);
		} 
		catch (IOException e) {
			g.drawString("LIVES", 20, 35);
		}
		
		g.drawString(" x " + livesLeft, 45, 35);
		
	}
	
	public void drawSimpleStats(Graphics g) {
		Color c = Color.WHITE;
		int x = 10;
		int y = Constants.getScreenHeight() - Constants.GAME_VIEW_HEIGHT / 10 + 10;
		
		g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 100));
		g.fillRect(x, y, 2 * (Constants.GAME_VIEW_WIDTH / 10), Constants.GAME_VIEW_HEIGHT / 15);
		
		x += 5;
		y += 15;
		
		String[] stats = {
			"HEALTH: 10",
			"MANA:    5",
			"LEVEL:    2"
		};
		
		g.setColor(Color.BLACK);
		for (String s : stats) {
			g.drawString(s, x, y);
			y += 15;
		}
	}
	
	
	// -------------
	
	public void addAvatarKeyBinding(ArrayList<KeyListener> kbList){
        for(int i = 0; i < kbList.size(); i++){
            addKeyListener(kbList.get(i));
        }
    }
	
	public void activateAvatarTile() {
		this.currentTile = avatarTile;
		this.scrolling = false;
	}
	
	public void activateScrollableTile() {
		this.currentTile = scrollableTile;
		this.scrolling = true;
	}
	
	public void setAvatarTile(Tile tile) {
		this.avatarTile = tile;
		setScrollableTile(tile);
	}
	
	public Tile getAvatarTile() {
		return this.avatarTile;
	}
	
	public void setScrollableTile(Tile tile) {
		this.scrollableTile = tile;
	}
	
	public Tile getScrollableTile() {
		return this.scrollableTile;
	}
	
	public boolean isScrolling() {
		return this.scrolling;
	}
	
	
}
