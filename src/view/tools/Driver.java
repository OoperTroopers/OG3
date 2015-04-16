// this is just a driver to run the view
// until we have a controller to do that

package view.tools;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.view.View;
import model.map.GrassTerrain;
import model.map.Terrain;
import model.map.Tile;

public class Driver {
	
	static JFrame jf;
	
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

		// initialize everything
		jf = new JFrame();
		jf.setSize(600,800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		JPanel newPanel = new View();
		jf.add(newPanel);
		
		try {
			BufferedImage img = ImageIO.read(new File("res/img/grass_terrain.png"));
			Graphics2D g2 = img.createGraphics();
			
			
		} catch (IOException e) {
			System.out.println("trouble finding object");
			e.printStackTrace();
		}

		
		/*Terrain gt = new GrassTerrain();
		Tile t = new Tile();
		t.drawView();*/
		
	}
}