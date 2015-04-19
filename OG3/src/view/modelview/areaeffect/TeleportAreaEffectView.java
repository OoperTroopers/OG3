package view.modelview.areaeffect;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class TeleportAreaEffectView extends AreaEffectView {
	BufferedImage image;
	
	public TeleportAreaEffectView() {
		try { image = ImageIO.read(new File(ImagePaths.TELEPORT));} 
		catch (IOException e) {}	
	}
	
	@Override
	public BufferedImage getImage() {
		return image;
	}
}
