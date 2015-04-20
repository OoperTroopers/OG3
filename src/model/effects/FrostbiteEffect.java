package model.effects;

import model.entities.Avatar;
import model.entities.Entity;

public class FrostbiteEffect extends TimedDamageEffect {
	public FrostbiteEffect() {
		super();
	}
	
	@Override
	public void visit(Avatar avatar) {
		System.out.println("Visited by avatar");
		avatar.receiveDamage(10);
		System.out.println(avatar.getStats().getCurrentHealth());
	}
	
	@Override
	public void visit(Entity entity) {
		System.out.println("Accepted by entity");
		entity.receiveDamage(10);
		System.out.println(entity.getStats().getCurrentHealth());
	}
}
