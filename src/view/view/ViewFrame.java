package view.view;

import java.awt.Color;

import javax.swing.JFrame;

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
		game.setBackground(Color.black);
		addViewport(game);
		
		Tile center_tile = new Tile();
		center_tile.setTerrain(new GrassTerrain());
		center_tile.setLocation(1,1,1);
		center_tile.draw();
		
		Tile another_tile = new Tile();
		another_tile.setTerrain(center_tile.getTerrainClone());
		another_tile.setLocation(0, 0, 0);
		another_tile.draw();
		
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
}
