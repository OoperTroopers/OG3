package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class DamagingOneShotItemView extends OneShotItemView {
	BufferedImage image;
	
	public DamagingOneShotItemView() {
		try { image = ImageIO.read(new File(ImagePaths.DAMAGING_ONE_SHOT_ITEM));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
