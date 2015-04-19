package view.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;

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
	// static HeartsViewport heartsViewport = HeartsViewport.getInstance();
	// static SimpleStatsViewport simpleStatsViewport = SimpleStatsViewport.getInstance();
	
	Load load = new Load();
	
	private static ActiveGameViewport activeGameViewport = 
			new ActiveGameViewport();

	public ActiveGameViewport() {
		this.setPreferredSize(new Dimension(Constants.GAME_VIEW_HEIGHT,Constants.GAME_VIEW_WIDTH));
		this.setBackground(new Color(44,62,80));
		
		// add other viewports
		// this.add(heartsViewport);
		// this.add(simpleStatsViewport);
		
                
                
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
		viewportStack.add(this);
	}
	
	public static ActiveGameViewport getInstance() {
		return activeGameViewport;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Point p;
		List<Tile> tiles = TileAlgorithm.getAllTiles(currentTile);
		
		Tile start = this.currentTile;
		
		Point pixels = TileAlgorithm.toPixel(start);
		int dx = this.getWidth() / 2 - pixels.x;
		int dy = this.getHeight() / 2 - pixels.y;
		
		for (Tile t : tiles) {
			p = TileAlgorithm.toPixel(t);
			TileView tileView = t.getTileView();
			if(tileView.hasBeenSeen()){
				//for (TileableView tv : tileView.getList()){
					//BufferedImage image = tv.getImage();
					//int age = tileView.getAge();
					if (!this.isScrolling()) tileView.incrementAge();
					
					/*float scaleFactor = 1.0f - (float)age/100.0f;
					if(scaleFactor<0.5f){
						scaleFactor = 0.5f;
					}
					*/
					//scaleFactor = 1.0f;
					//float scaleFactor = .9f;
					//RescaleOp op = new RescaleOp(scaleFactor, 0, null);
					//image = op.filter(image, image);
					g.drawImage(tileView.getImage(), p.x + dx, p.y + dy, 
						Constants.TILE_HEIGHT, Constants.TILE_WIDTH, null);
					
				//}
			}
			
		}
	}
	
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
