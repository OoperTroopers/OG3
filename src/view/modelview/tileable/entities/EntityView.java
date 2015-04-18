package view.modelview.tileable.entities;

import view.modelview.tileable.TileableView;

public abstract class EntityView implements TileableView {

	@Override
	public int getPriority() {
		return 5;
	}
}
