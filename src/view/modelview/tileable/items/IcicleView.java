package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class IcicleView extends ItemView {
	BufferedImage image;
	
	public IcicleView() {
		try { image = ImageIO.read(new File(ImagePaths.ICICLE_TIMED_ITEM));} 
		catch (IOException e) {}	
	}
	
	@Override
	public BufferedImage getImage() {
		return image;
	}

}
