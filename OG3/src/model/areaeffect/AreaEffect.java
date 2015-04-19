package model.areaeffect;

import model.entities.Avatar;
import model.entities.Entity;
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
	
	public abstract void activate(Entity entity);
	public void acceptAvatar(Avatar avatar) {
		this.activate(avatar);
	}
}
