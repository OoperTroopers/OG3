package model.effects;

import model.entities.*;

public class HealEffect extends Effect {
	
	public void visit(Entity entity) {
		entity.heal(10);
	}
	public void visit(Mount entity) {
		entity.heal(10);
	}
	public void visit(NPC entity) {
		entity.heal(10);
	}
	
}
