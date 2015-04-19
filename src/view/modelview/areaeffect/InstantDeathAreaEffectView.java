package view.modelview.areaeffect;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class InstantDeathAreaEffectView extends AreaEffectView {

	BufferedImage image;
	
	public InstantDeathAreaEffectView() {
		try { image = ImageIO.read(new File(ImagePaths.SKULL));} 
		catch (IOException e) {}	
	}
	
	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
