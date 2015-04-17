package view.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.tools.ImagePaths;
import view.tools.ViewPosition;
import model.map.GrassTerrain;
import model.map.Tile;

public class ViewFrame extends JFrame {
	static View view;
	
	public ViewFrame() {
		view = View.getInstance();
		
		this.setSize(600,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		view.stylize();
		
		this.add(view);

	}
	
	public void addViewport(Viewport viewport) {
		System.out.println("Viewport added");
		view.addViewport(viewport);
	}
	
	public void initialize() {
		ActiveGameViewport game = ActiveGameViewport.getInstance();
		addViewport(game);
		
		/*Tile center_tile = new Tile();
		center_tile.setTerrain(new GrassTerrain());
		center_tile.setLocation(1,1,1);
		center_tile.draw();
		 
		*/
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(ImagePaths.GRASS_TERRAIN));
		    System.out.println("Drawing image");
			game.draw(img, 10,10,60,60);
			System.out.println("Drew it");
		} catch (IOException e) {
		}
		
		
		/*for (Direction d : Direction.values()) {
			// make it
			Tile tempTile = new Tile();
			
			// customize it
			tempTile.setTerrain(center_tile.getTerrainClone());
			center_tile.addNeighbor(tempTile, d);
			
			Direction oppositeDirection = d.leftTurn().leftTurn().leftTurn(); // opposite direction
			tempTile.addNeighbor(center_tile, oppositeDirection);
			
			tempTile.drawView();
			
		}*/
	}

	public static Component getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
