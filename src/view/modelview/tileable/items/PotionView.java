package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class PotionView extends TakeableItemView{

	BufferedImage image;
	
	public PotionView() {
		try { image = ImageIO.read(new File(ImagePaths.POTION));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
