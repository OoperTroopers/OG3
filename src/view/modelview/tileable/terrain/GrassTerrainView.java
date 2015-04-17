package view.modelview.tileable.terrain;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import model.map.Location;
import view.tools.ImagePaths;
import view.tools.ViewPosition;
import view.view.ActiveGameViewport;
import view.view.View;
import view.view.Viewport;

public class GrassTerrainView extends TerrainView {
	ImageIcon img;
	Image image;
	ViewPosition viewPosition;
	
	public GrassTerrainView() {
		try { image = ImageIO.read(new File(ImagePaths.GRASS_TERRAIN));} 
		catch (IOException e) {}	
	}
	
	public GrassTerrainView(ViewPosition viewPosition) {
		this.viewPosition = viewPosition;
		img = new ImageIcon(ImagePaths.GRASS_TERRAIN);
	}
	
	public Image getImage() { return image; }
	
	public void setPosition(ViewPosition viewPosition) {
		this.viewPosition = viewPosition;
	}
	
	public void draw() {
		ActiveGameViewport activeGameViewport = ActiveGameViewport.getInstance();
		if (viewPosition != null) {
			System.out.println("Draw with position");
			activeGameViewport.draw(img, viewPosition);
		}
		else {
			System.out.println("Draw without position");
			activeGameViewport.draw(img);
		}
	}
	
	@Override
	public void setLocation(Location location) {
		// TODO Auto-generated method stub
		
	}
}
