package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class DoorView extends InteractiveItemView{

	BufferedImage image;
	
	public DoorView() {
		try { image = ImageIO.read(new File(ImagePaths.DOOR));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
