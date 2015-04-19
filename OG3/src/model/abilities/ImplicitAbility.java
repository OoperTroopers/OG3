package model.abilities;

public abstract class ImplicitAbility extends Ability {
	public ImplicitAbility() {
		super();
		setName("Implicit Ability");
	}
	
	public void perform() {
		System.out.println("Skill boost");
	}
}
