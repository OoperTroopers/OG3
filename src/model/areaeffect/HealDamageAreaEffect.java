package model.areaeffect;

import model.effects.Effect;
import model.effects.HealEffect;
import model.entities.Entity;
import model.map.Tile;
import view.modelview.areaeffect.HealDamageAreaEffectView;
import view.modelview.tile.TileView;

public class HealDamageAreaEffect extends AreaEffect {
	private static HealDamageAreaEffectView healDamageAreaEffectView = new HealDamageAreaEffectView();
	private Effect effect;

	public HealDamageAreaEffect() {
		super(healDamageAreaEffectView);
		this.effect = new HealEffect();
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
