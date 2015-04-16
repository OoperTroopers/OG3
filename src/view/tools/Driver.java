// this is just a driver to run the view
// until we have a controller to do that

package view.tools;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.view.View;
import model.map.GrassTerrain;
import model.map.Terrain;
import model.map.Tile;

public class Driver {
	
	static JFrame jf;
	public static void main(String[] args) {

		// initialize everything
		jf = new JFrame();
		jf.setSize(600,800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		JPanel newPanel = new View();
		jf.add(newPanel);
		
		Terrain gt = new GrassTerrain();
		Tile t = new Tile();
		t.drawView();
	}
}
