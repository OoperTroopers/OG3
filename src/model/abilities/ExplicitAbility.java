package model.abilities;

import model.statistics.Statistics;
import controller.KeyBinding;
import controller.ControllerAvatar;

public abstract class ExplicitAbility extends Ability {
	private KeyBinding keyBinding;
	
	public ExplicitAbility() {
		super();
		this.keyBinding = null;
	}
	
	public ExplicitAbility(Statistics avatarStats, int skillLevel, String name, char keyToBind) {
		super(avatarStats, skillLevel, name);
		this.keyBinding = new KeyBinding(keyToBind, this);
	}
	
	public void perform() {
		System.out.println("ALLAHU ACKBAR");
	}
	
	public void attachToController(ControllerAvatar controlAvatar) {
		controlAvatar.addToKLSet(keyBinding);
	}
}
