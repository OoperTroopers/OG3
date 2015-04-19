package view.modelview.tileable.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class PetView extends NPCView{
	BufferedImage image;
	
	public PetView() {
		try { image = ImageIO.read(new File(ImagePaths.PET));} 
		catch (IOException e) {}	
	}
	
	@Override
	public BufferedImage getImage() {
		return image;
	}
}
