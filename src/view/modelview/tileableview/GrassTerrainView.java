package view.modelview.tileableview;

import java.awt.image.BufferedImage;
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
	
	
}
