package view.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import controller.GameController;
import controller.PauseMenuController;
import controller.KeyBinding;
import model.entities.Avatar;
import model.entities.Entity;
import model.inventory.Inventory;
import model.loadsave.FilePaths;
import model.loadsave.Load;
import model.map.Tile;
import model.statistics.DerivedStatistics;
import model.statistics.PrimaryStatistics;
import model.statistics.Statistics;
import utilities.TileAlgorithm;
import view.modelview.tile.TileView;
import view.tools.Constants;
import view.tools.ImagePaths;

public class ActiveGameViewport extends Viewport {
	
	Tile currentTile;
	Tile scrollableTile;
	Tile avatarTile;
	boolean scrolling = false;
	int livesLeft = 3;
	PrimaryStatistics primaries;
	DerivedStatistics deriveds;
	Statistics stats;
		// LOD
	
	Inventory inventory;
	
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
		System.out.println("about to get primaries");
		primaries = avatar.getStats().getPrimaryStats();
		deriveds = avatar.getStats().getDerivedStats();
		stats = avatar.getStats();
		inventory = avatar.getInventory();
		
		this.addAvatarKeyBinding(((Avatar) avatar).getKeyBinding());
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_P) {
					GameController.getInstance().addToStack(GameController.getInstance().getActiveController());
					GameController.getInstance().swapViews(new PauseMenuController());
					
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
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
		drawInventory(g);
	}
	// ----------------
	
	private void drawInventory(Graphics g) {
		System.out.println("inventory");
		Color c = Color.WHITE;
		int x = Constants.getScreenWidth() - Constants.GAME_VIEW_WIDTH / 10 + 840;
		System.out.println("x is "+x);
		int y = Constants.getScreenHeight() - Constants.GAME_VIEW_HEIGHT / 10 + 620;
		System.out.println("y is "+y);
		
		g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 100));
		g.fillRect(x, y, 2 * (Constants.GAME_VIEW_WIDTH / 10) + 340, Constants.GAME_VIEW_HEIGHT / 15 + 70);
		
		x += 5;
		int newY = y + 15;
		
		String[] items = inventory.toString().split("\n");
		g.setColor(Color.BLACK);
		g.drawString("INVENTORY", x, newY);
		newY += 10;
		int counter = 0;
		for (String s : items) {
			newY += 15;
			g.drawString(s, x, newY);
			counter ++;
			if (counter == 5) {
				newY = y + 25;
				x += 60;
			}
		}
	}

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
		int xStart = ViewFrame.getInstance().getWidth() + 1100;
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
		
		g.drawString(" x " + primaries.getLivesLeft(), 45, 35);
		
	}
	
	public void drawSimpleStats(Graphics g) {
		Color c = Color.WHITE;
		int x = 10;
		int y = Constants.getScreenHeight() - Constants.GAME_VIEW_HEIGHT / 10 + 625;
		
		g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 100));
		g.fillRect(x, y, 2 * (Constants.GAME_VIEW_WIDTH / 10) + 340, Constants.GAME_VIEW_HEIGHT / 15 + 70);
		
		x += 5;
		int newY = y + 15;
		
		String[] primary = primaries.toString().split("\n");
		String[] derived = deriveds.toString().split("\n");
		String[] stat = stats.toString().split("\n");
		g.setColor(Color.BLACK);
		g.drawString("STATS", x, newY);
		newY += 10;
		for (String s : stat) {
			newY += 15;
			g.drawString(s, x, newY);
		}
		
		x += 150;
		newY = y + 15;
		g.drawString("PRIMARY STATS", x, newY);
		newY += 10;
		for (String s : primary) {
			newY += 15;
			g.drawString(s, x, newY);
		}
		
		x += 130;
		newY = y + 15;
		g.drawString("DERIVED STATS", x, newY);
		newY += 10;
		for (String s : derived) {
			newY += 15;
			g.drawString(s, x, newY);
		}
		
	}
	
	
	// -------------
	
	public void addAvatarKeyBinding(ArrayList<KeyListener> kbList){
        for(int i = 0; i < kbList.size(); i++){
            addKeyListener(kbList.get(i));
        }
    }

	public void addSingleAvatarKeyBinding(KeyBinding keyBinding){
		addKeyListener(keyBinding);
	}

	public void removeSingleAvatarKeyBinding(KeyBinding keyBinding){
		removeKeyListener(keyBinding);
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

	public void updatePrimaries(PrimaryStatistics primaries) {
		this.primaries = primaries;
	}

	public void updateDeriveds(DerivedStatistics deriveds) {
		this.deriveds = deriveds;
	}

	public void updateStats(Statistics stats) {
		this.stats = stats;
	}
	
	public void updateInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
}
