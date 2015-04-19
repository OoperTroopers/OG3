package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class LegsView extends ArmorView{

	BufferedImage image;
	
	public LegsView() {
		try { image = ImageIO.read(new File(ImagePaths.LEGS));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
