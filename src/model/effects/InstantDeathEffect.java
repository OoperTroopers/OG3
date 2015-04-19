package model.effects;

import model.entities.Entity;

public class InstantDeathEffect extends DamageEffect {
	public void visit(Entity entity) {
		entity.receiveDamage(9999);
	}
}
