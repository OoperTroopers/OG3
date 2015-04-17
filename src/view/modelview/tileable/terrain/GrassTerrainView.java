package view.modelview.tileable.terrain;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import model.map.Location;
import view.tools.ImagePaths;
import view.tools.ViewPosition;
import view.view.ActiveGameViewport;
import view.view.View;
import view.view.Viewport;

public class GrassTerrainView extends TerrainView {
	ImageIcon img;
	ViewPosition viewPosition;
	
	public GrassTerrainView() {
		img = new ImageIcon(ImagePaths.GRASS_TERRAIN);
	}
	
	public GrassTerrainView(ViewPosition viewPosition) {
		this.viewPosition = viewPosition;
		img = new ImageIcon(ImagePaths.GRASS_TERRAIN);
	}
	
	public void draw() {
		ActiveGameViewport activeGameViewport = ActiveGameViewport.getInstance();
		if (viewPosition != null)
			activeGameViewport.draw(img, viewPosition);
		else
			activeGameViewport.draw(img);
	}
		
	public ImageIcon getImage() {
		return img;
	}

	@Override
	public void setLocation(Location location) {
		// TODO Auto-generated method stub
		
	}
}
