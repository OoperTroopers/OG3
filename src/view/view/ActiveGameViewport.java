package view.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.loadsave.FilePaths;
import model.loadsave.Load;
import model.map.Tile;
import utilities.TileAlgorithm;
import utilities.TileAlgorithm.Direction;
import view.tools.Constants;
import view.tools.ImagePaths;
import view.tools.ViewPosition;

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
	}
	
	@Override
	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
	
	public static ActiveGameViewport getInstance() {
		return activeGameViewport;
	}
	
	public void draw(ImageIcon i) {
		System.out.println("drawing image");
		this.add(new JLabel(i));
	}
	
	public void draw(ImageIcon i, ViewPosition viewPosition) {
		System.out.println("drawing image W ViewPosition");
		JLabel toDraw = new JLabel(i);
		System.out.println("\nBounds are ("+viewPosition.getX()+", "+viewPosition.getY()+")\n");
		toDraw.setBounds(viewPosition.getX(), viewPosition.getY(), 
				Constants.TILE_WIDTH, Constants.TILE_HEIGHT);
		this.setAlignmentX(0);
		System.out.println("Container bounds are ("+this.getAlignmentX()+", "+this.getAlignmentY()+")");
		this.add(toDraw);
	}
	
	public void draw(Image i, int x, int y, int height, int width) {
		Graphics g = this.getGraphics();
		System.out.println("Draw 1");
		boolean a = g.drawImage(i, x, y, x+height, y+width, null);
		g.finalize();
		System.out.println("Draw 2, result is "+a);
	}
	
	@Override
	public void paint(Graphics g) {
		// paint this tile
		/*Point p = TileAlgorithm.toPixel(currentTile);
		g.drawImage(currentTile.getTerrainImage(), p.x, p.y, 
				Constants.TILE_HEIGHT, Constants.TILE_WIDTH, null);*/
		
		// move to next
		Point p;
		List<Tile> tiles = TileAlgorithm.getAllTiles(currentTile);
		for (Tile t : tiles) {
			p = TileAlgorithm.toPixel(t);
			System.out.println("("+p.x+", "+p.y+")");
			g.drawImage(t.getTerrainImage(), p.x, p.y, 
					Constants.TILE_HEIGHT, Constants.TILE_WIDTH, null);
		}
	}
}
