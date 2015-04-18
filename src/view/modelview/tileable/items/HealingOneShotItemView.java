package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class HealingOneShotItemView extends OneShotItemView {
BufferedImage image;
	
	public HealingOneShotItemView() {
		try { image = ImageIO.read(new File(ImagePaths.HEALING_ONE_SHOT_ITEM));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
