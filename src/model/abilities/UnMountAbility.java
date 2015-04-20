package model.abilities;

import model.effects.Effect;
import model.entities.Entity;
import controller.KeyBinding;

public class UnMountAbility extends ExplicitAbility {
	Entity avatar;
	public UnMountAbility() {
		super();
	}
	
	public UnMountAbility(char keyToBind) {
		super();
		setName("UnMount Ability");

	}
	
	public UnMountAbility(Entity avatar, char keyToBind) {
		super();
		this.avatar = avatar;
		setName("UnMount Ability");
		
	}
	
	 @Override
	 public void perform() {
		avatar.setMount(null);
		System.out.println("I UNMOUNTED");
	} 
}
