package model.effects;

import model.entities.Entity;

public class TrapEffect extends DamageEffect {
	//hide tile until visited or sneak
	public void visit(Entity entity) {
		entity.receiveDamage(10);
	}
}
