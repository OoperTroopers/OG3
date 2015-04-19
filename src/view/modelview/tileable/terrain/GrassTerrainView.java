package view.modelview.tileable.terrain;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class GrassTerrainView extends TerrainView {
	BufferedImage image;
	
	public GrassTerrainView() {
		try { image = ImageIO.read(new File(ImagePaths.GRASS_TERRAIN));} 
		catch (IOException e) {}	
	}

        @Override
	public BufferedImage getImage() { return image; }
	
        @Override
    	public void darken() {
    		RescaleOp op = new RescaleOp(0.8f, 0, null);
    		image = op.filter(image, image);
    		
    	}

    	@Override
    	public void lighten() {
    		try { image = ImageIO.read(new File(ImagePaths.GRASS_TERRAIN));} 
    		catch (IOException e) {}
    		
    	}
}
