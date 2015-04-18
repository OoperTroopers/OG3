package view.modelview.tileable.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.tools.ImagePaths;

public class TreasureChestView extends InteractiveItemView{

	BufferedImage image;
	
	public TreasureChestView() {
		try { image = ImageIO.read(new File(ImagePaths.TREASURE_CHEST));} 
		catch (IOException e) {}	
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
}
