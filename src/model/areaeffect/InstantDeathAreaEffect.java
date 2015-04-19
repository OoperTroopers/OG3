package model.areaeffect;

import model.effects.Effect;
import model.effects.InstantDeathEffect;
import model.entities.Entity;
import model.map.Tile;
import view.modelview.areaeffect.InstantDeathAreaEffectView;
import view.modelview.tile.TileView;

public class InstantDeathAreaEffect extends AreaEffect{
	private static InstantDeathAreaEffectView instantDeathAreaEffectView = new InstantDeathAreaEffectView();
	private Effect effect;

	public InstantDeathAreaEffect() {
		super(instantDeathAreaEffectView);
		this.effect = new InstantDeathEffect();
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

	}
	
	public void activate(Entity entity) {
		effect.visit(entity);
	}
}
