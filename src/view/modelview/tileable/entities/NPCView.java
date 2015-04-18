package view.modelview.tileable.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class NPCView extends EntityView {
	BufferedImage image;
	
	public NPCView() {
		try { image = ImageIO.read(new File(ImagePaths.AVATAR));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
