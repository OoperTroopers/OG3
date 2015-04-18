package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class TwoHandedView extends WeaponView {

	BufferedImage image;
	
	public TwoHandedView() {
		try { image = ImageIO.read(new File(ImagePaths.TWO_HANDED));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
