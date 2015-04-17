package view.modelview.tileableview;

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
	Image image;
	
	public GrassTerrainView() {
		try { image = ImageIO.read(new File(ImagePaths.GRASS_TERRAIN));} 
		catch (IOException e) {}	
	}
		
	public Image getImage() { return image; }

}
