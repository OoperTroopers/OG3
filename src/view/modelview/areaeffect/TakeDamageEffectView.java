package view.modelview.areaeffect;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class TakeDamageEffectView extends AreaEffectView{

	BufferedImage image;
	
	public TakeDamageEffectView() {
		try { image = ImageIO.read(new File(ImagePaths.TAKE_DAMAGE));} 
		catch (IOException e) {}	
	}
	
	@Override
	public BufferedImage getImage() {
		return image;
	}

}
