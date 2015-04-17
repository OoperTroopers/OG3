package view.modelview.tileableview;

import java.awt.Image;

import view.modelview.tileable.TileableView;

public abstract class ItemView implements TileableView {

	@Override
	public int getPriority() {
		return 4;
	}
	
}
