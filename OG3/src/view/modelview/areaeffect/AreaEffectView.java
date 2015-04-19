package view.modelview.areaeffect;

import view.modelview.tileable.TileableView;

public abstract class AreaEffectView implements TileableView{

	@Override
	public int getPriority() {
		return 2;
	}
}
