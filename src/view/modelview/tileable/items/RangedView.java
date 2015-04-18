package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class RangedView extends WeaponView{

	BufferedImage image;
	
	public RangedView() {
		try { image = ImageIO.read(new File(ImagePaths.BOW));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
