package view.modelview.tileable.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class MountView extends NPCView {
	BufferedImage image;
	private int viewPriority = 4;
	
	public MountView() {
		try { image = ImageIO.read(new File(ImagePaths.MOUNT));} 
		catch (IOException e) {}	
	}
	
	@Override
	public BufferedImage getImage() {
		return image;
	}
	
	@Override
	public int getPriority() { return viewPriority; }
	
	public void togglePriority() {
		viewPriority = 10 - viewPriority;
		// toggles between 4 and 6. since the entity is 5.
	}
}
