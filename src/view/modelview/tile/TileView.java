package view.modelview.tile;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class TileView {
	BufferedImage img;

	public TileView() {
		// It knows what it looks like. This is a view. That's okay. 
		// If you don't like it, deal.
		
		try {
			img = ImageIO.read(new File("res/img/grass_terrain.png"));
		} catch (IOException e) {
			System.out.println("doesn't read grass terrain image");
			e.printStackTrace();
		}
		
	}
	public void draw() {
		//      Questionable design decision, but I'm letting our "Pen"
		// be available anywhere. Static and Global. 
		//      That means that anyone can draw on our screen. Alternative is 
		// to pass it through the main method. Thoughts?
		
		
	}
}
