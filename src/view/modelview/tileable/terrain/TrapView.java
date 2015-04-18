package view.modelview.tileable.terrain;

import model.map.Location;
import view.modelview.tileable.TileableView;

//MOVE THIS INTO A DIFFERENT PACKAGE!!!
public abstract class TrapView implements TileableView {

	@Override
	public int getPriority() {
		return 3;
	}

}
