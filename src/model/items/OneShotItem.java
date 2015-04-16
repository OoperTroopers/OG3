package model.items;

import model.effects.Effect;
import model.entities.Entity;

public abstract class OneShotItem extends Item {

	private Effect effect;
	
	public OneShotItem(Effect effect) {
		this.effect = effect;
	}
	
	public void touch(Entity entity) {
		effect.visit(entity);
	}
	
}
