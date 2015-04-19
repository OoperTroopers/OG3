package model.effects;

import model.entities.Entity;

public class HealEffect extends Effect {
	
	public void visit(Entity entity) {
		entity.heal(10);
	}
	
}
