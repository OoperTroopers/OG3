package model.areaeffect;

import model.effects.Effect;
import model.effects.DamageEffect;
import model.entities.Entity;
import view.modelview.areaeffect.TakeDamageAreaEffectView;
import view.modelview.tile.TileView;

public class TakeDamageAreaEffect extends AreaEffect {
	private static TakeDamageAreaEffectView takeDamageAreaEffectView = new TakeDamageAreaEffectView();
	private Effect effect;
	
	public TakeDamageAreaEffect() {
		super(takeDamageAreaEffectView);
		this.effect = new DamageEffect();
		
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
