package model.effects;

/**
 * Fireball represents a specific effect that causes an Entity to take constant damage for a
 * fixed amount of time.
 * @author Cormac McCarthy
 */

import model.entities.Entity;

public class Fireball extends BurnEffect {

	@Override
	public void visit(Entity entity) {
		entity.receiveDamage(10);
	}
	
}
