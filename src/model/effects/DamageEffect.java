package model.effects;

import model.entities.Entity;

public class DamageEffect extends Effect {
	
	public void visit(Entity entity) {
		entity.receiveDamage(10);
	}
	
}