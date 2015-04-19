package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class ChestView extends ArmorView {

	BufferedImage image;
	
	public ChestView() {
		try { image = ImageIO.read(new File(ImagePaths.CHEST));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
