package view.modelview.areaeffect;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class TrapAreaEffectView extends AreaEffectView {
	BufferedImage image;
	
	public TrapAreaEffectView() {
		//change to trap
		try { image = ImageIO.read(new File(ImagePaths.TAKE_DAMAGE));} 
		catch (IOException e) {}	
	}
	
	@Override
	public BufferedImage getImage() {
		return image;
	}
}