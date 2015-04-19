package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class StaffView extends WeaponView{

	BufferedImage image;
	
	public StaffView() {
		try { image = ImageIO.read(new File(ImagePaths.STAFF));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
