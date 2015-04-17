package view.modelview.tileable.terrain;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import model.map.Location;
import view.view.View;

public class GrassTerrainView {
	ImageIcon img;
	
	public GrassTerrainView() {
		img = new ImageIcon("res/img/grass_terrain.png");
	}
	
	public void draw() {
		View view = View.getInstance();
		// view.getActionGameView();
	}
}
