package view.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.util.List;

import controller.RunGame;

import model.entities.Avatar;
import model.entities.Entity;
import model.loadsave.FilePaths;
import model.loadsave.Load;
import model.map.Tile;
import utilities.TileAlgorithm;
import view.modelview.tileable.TileableView;
import view.tools.Constants;

@SuppressWarnings("serial")
public class ActiveGameViewport extends Viewport {
	Tile currentTile;
	Load load = new Load();
	
	int[][] tiles = {
			{5, 5},
			{85,5},
			{165,5},
			{245,6}
	};	// will be phased out. just to give you an idea of what's going on conceptually.
	
	private static ActiveGameViewport activeGameViewport = 
			new ActiveGameViewport();

	public ActiveGameViewport() {
		this.setPreferredSize(new Dimension(400,400));
		
		this.setBackground(Color.BLACK);
		
		// get beginning tile
		try {load.read(FilePaths.DEFAULT);} 
		catch (IOException e) {e.printStackTrace();}
		currentTile = load.getBeginningTile();
		Entity avatar = new Avatar(currentTile);
		RunGame rg = new RunGame((Avatar) avatar);
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
		for (Tile t : tiles) {
			p = TileAlgorithm.toPixel(t);
			
			for (TileableView tv : t.getTileableViews())
				g.drawImage(tv.getImage(), p.x, p.y, 
					Constants.TILE_HEIGHT, Constants.TILE_WIDTH, null);
		}
	}
}
