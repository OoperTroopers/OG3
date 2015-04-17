package view.modelview.tileableview;

import model.map.Location;
import view.modelview.tileable.TileableView;

public abstract class TrapView implements TileableView {

	@Override
	public int getPriority() {
		return 3;
	}

}
