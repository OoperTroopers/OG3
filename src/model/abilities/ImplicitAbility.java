package model.abilities;

import model.statistics.Statistics;

public abstract class ImplicitAbility extends Ability {
	public ImplicitAbility() {
		super();
	}
	
	public ImplicitAbility(Statistics avatarStats, int skillLevel, String name) {
		super(avatarStats, skillLevel, name);
	}
	
	public void perform() {
		System.out.println("Skill boost");
	}
}
