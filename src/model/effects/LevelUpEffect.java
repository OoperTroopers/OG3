package model.effects;

import model.entities.Entity;

public class LevelUpEffect extends Effect {
	public void visit(Entity entity) {
		entity.increaseExperience(entity.getCurrentLevel() * 10 + 90);
	}
}
