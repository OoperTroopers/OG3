package model.effects;

import model.entities.Entity;

public class LevelUpEffect {
	public void visit(Entity entity) {
		entity.increaseExperience(entity.getCurrentLevel() * 10 + 90);
	}
}
