package view.modelview.tileable.items;

import view.modelview.tileable.TileableView;

public abstract class ItemView implements TileableView{

	@Override
	public int getPriority() {
		return 4;
	}
}
