package model.items;

import model.effects.Effect;
import model.entities.Entity;

public abstract class OneShotItem extends Item {

	private Effect effect;
	
	public OneShotItem(Effect effect) {
		this.effect = effect;
	}
	
	@Override
	public void touch(Entity entity) {
		effect.visit(entity);
	}
	
	@Override
	public boolean isPassable() {
		return true;
	}
	
	@Override
	public boolean isTraversable() {
		return true;
	}
	
}
