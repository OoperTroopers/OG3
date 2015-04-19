package model.areaeffect;

import model.effects.Effect;
import model.effects.TeleportEffect;
import view.modelview.areaeffect.TeleportAreaEffectView;
import view.modelview.tile.TileView;

public class TeleportAreaEffect extends AreaEffect {
	private static TeleportAreaEffectView teleportAreaEffectView = new TeleportAreaEffectView();
	private TeleportEffect effect;
	
	public TeleportAreaEffect() {
		super(teleportAreaEffectView);
		this.effect = new TeleportEffect();
	}

	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);
	}

	@Override
	public boolean isTraversable() {
		return true;
	}

	@Override
	public void removeFromView(TileView tileView) {
		// TODO Auto-generated method stub

	}

}
