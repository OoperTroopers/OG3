package view.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	Tile currentTile;
	// static HeartsViewport heartsViewport = HeartsViewport.getInstance();
	// static SimpleStatsViewport simpleStatsViewport = SimpleStatsViewport.getInstance();
	
	Load load = new Load();
	
	private static ActiveGameViewport activeGameViewport = 
			new ActiveGameViewport();

	public ActiveGameViewport() {
		this.setPreferredSize(new Dimension(Constants.GAME_VIEW_HEIGHT,Constants.GAME_VIEW_WIDTH));
		this.setBackground(Color.BLACK);
		
		// add other viewports
		// this.add(heartsViewport);
		// this.add(simpleStatsViewport);
		
                
                
		// get beginning tile
		try {load.read(FilePaths.DEFAULT);} 
		catch (IOException e) {e.printStackTrace();}
		currentTile = load.getBeginningTile();
		System.out.println("currentTile = " + currentTile);
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
		System.out.println("PAINTED");
		Point p;
		List<Tile> tiles = TileAlgorithm.getAllTiles(currentTile);
		
		Tile start = this.currentTile;
		Point pixels = TileAlgorithm.toPixel(start);
		int dx = this.getWidth() / 2 - pixels.x;
		int dy = this.getHeight() / 2 - pixels.y;
		
		for (Tile t : tiles) {
			p = TileAlgorithm.toPixel(t);
			TileView tileView = t.getTileView();
			for (TileableView tv : tileView.getList())
				g.drawImage(tv.getImage(), p.x + dx, p.y + dy, 
					Constants.TILE_HEIGHT, Constants.TILE_WIDTH, null);
		}
	}
	
	public void addAvatarKeyBinding(ArrayList<KeyListener> kbList){
        for(int i = 0; i < kbList.size(); i++){
            addKeyListener(kbList.get(i));
        }
    }
	
	public void setAvatarTile(Tile tile) {
		this.currentTile = tile;
	}
	
	public Tile getAvatarTile() {
		return this.currentTile;
	}
}
