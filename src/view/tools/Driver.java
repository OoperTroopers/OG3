// this is just a driver to run the view
// until we have a controller to do that

package view.tools;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import utilities.TileAlgorithm.Direction;
import view.view.View;
import view.view.ViewFrame;
import model.map.GrassTerrain;
import model.map.Terrain;
import model.map.Tile;

public class Driver {
	
	static ViewFrame vf;
	
	public static void main(String[] args) {
		// @SuppressWarnings("unused")
		Driver game = new Driver();
	}
	
	public Driver() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				createAndShowGui();
			}
		});
	}
	
	public static void createAndShowGui() {
		vf = new ViewFrame();
		
		Tile center_tile = new Tile();
		center_tile.setTerrain(new GrassTerrain());
		center_tile.setLocation(1,1,1);
		center_tile.drawView();
		
		for (Direction d : Direction.values()) {
			// make it
			Tile tempTile = new Tile();
			
			// customize it
			tempTile.setTerrain(center_tile.getTerrainClone());
			center_tile.addNeighbor(tempTile, d);
			
			Direction oppositeDirection = d.leftTurn().leftTurn().leftTurn(); // opposite direction
			tempTile.addNeighbor(center_tile, oppositeDirection);
			
			tempTile.drawView();
			
		}
			
		// JLabel jl = new JLabel(new ImageIcon("res/img/grass_terrain.png"));
		// vf.add(jl);

		
	}
}
