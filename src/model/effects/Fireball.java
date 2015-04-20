package model.effects;

import model.entities.Entity;
import model.entities.*;

/**
 * Fireball represents a specific effect that causes an Entity to take constant damage for a
 * fixed amount of time.
 * @author Cormac McCarthy
 */

public class Fireball extends BurnEffect {

	@Override
	public void visit(Entity entity) {
		entity.receiveDamage(10);
	}
	
	public void visit(Mount mount) {
		mount.receiveDamage(10);
	}
	
	public void visit(NPC npc) {
		npc.receiveDamage(10);
	}
	
}
