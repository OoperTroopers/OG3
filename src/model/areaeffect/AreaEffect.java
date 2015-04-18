package model.areaeffect;

import view.modelview.tile.TileView;
import view.modelview.tileable.TileableView;
import model.map.Tileable;

public abstract class AreaEffect implements Tileable {

	private TileableView areaEffectView;
	
	public AreaEffect(TileableView tileableView) {
		this.areaEffectView = tileableView;
	}

	@Override
	public void sendToView(TileView tileView) {
		tileView.accept(this.areaEffectView);		
	}
	
	public Tileable clone() {
		return null;
	}
}
