package view.modelview.tileable.entities;

import utilities.TileAlgorithm.Direction;
import view.modelview.tileable.TileableView;

public abstract class EntityView implements TileableView {

	@Override
	public int getPriority() {
		return 5;
	}
	
	public abstract void updateImage(Direction direction);
}
