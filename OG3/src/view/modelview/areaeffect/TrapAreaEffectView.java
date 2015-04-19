package view.modelview.areaeffect;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class TrapAreaEffectView extends AreaEffectView {
	BufferedImage hiddenImage;
	BufferedImage revealedImage;
	BufferedImage currentImage;
	
	public TrapAreaEffectView() {
		//changeTrap
		try { hiddenImage = ImageIO.read(new File(ImagePaths.HEART));
			revealedImage = ImageIO.read(new File(ImagePaths.TAKE_DAMAGE));} 
		catch (IOException e) {}	
		currentImage = hiddenImage;
	}
	
	@Override
	public BufferedImage getImage() {
		return currentImage;
	}
	
	public void switchImage() {
		currentImage = revealedImage;
	}
}