package view.modelview.tileable.entities;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import utilities.TileAlgorithm.Direction;
import view.tools.ImagePaths;

public class NPCView extends EntityView {
	BufferedImage image;
	
	public NPCView() {
		try { image = ImageIO.read(new File(ImagePaths.NPC));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
	
	public void updateImage(Direction direction) {
		
	}
}
