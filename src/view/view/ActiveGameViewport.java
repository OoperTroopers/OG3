package view.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.util.List;

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
	
	private static ActiveGameViewport activeGameViewport = 
			new ActiveGameViewport();

	public ActiveGameViewport() {
		this.setPreferredSize(new Dimension(Constants.GAME_VIEW_HEIGHT,Constants.GAME_VIEW_WIDTH));
		
		this.setBackground(Color.BLACK);
		
		// get beginning tile
		try {load.read(FilePaths.DEFAULT);} 
		catch (IOException e) {e.printStackTrace();}
		currentTile = load.getBeginningTile();
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
