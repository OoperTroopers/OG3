package view.modelview.tileable.entities;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import utilities.TileAlgorithm.Direction;
import view.tools.ImagePaths;

public class AvatarView extends EntityView {
	BufferedImage image;
	HashMap<Direction, BufferedImage> images;
	
	public AvatarView() {
		try { 
			image = ImageIO.read(new File(ImagePaths.AVATAR_SOUTH));
			images = new HashMap<Direction, BufferedImage>();
			images.put(Direction.NORTH, ImageIO.read(new File(ImagePaths.AVATAR_NORTH)));
			images.put(Direction.NORTHEAST, ImageIO.read(new File(ImagePaths.AVATAR_NORTHEAST)));
			images.put(Direction.NORTHWEST, ImageIO.read(new File(ImagePaths.AVATAR_NORTHWEST)));
			images.put(Direction.SOUTH, ImageIO.read(new File(ImagePaths.AVATAR_SOUTH)));
			images.put(Direction.SOUTHEAST, ImageIO.read(new File(ImagePaths.AVATAR_SOUTHEAST)));
			images.put(Direction.SOUTHWEST, ImageIO.read(new File(ImagePaths.AVATAR_SOUTHWEST)));
		} catch (IOException e) {}			
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
	
	public void updateImage(Direction direction) {
		this.image = images.get(direction);
	}
}
