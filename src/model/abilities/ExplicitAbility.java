package model.abilities;

import controller.KeyBinding;
import controller.ControllerAvatar;

public abstract class ExplicitAbility extends Ability {
	private KeyBinding keyBinding;
	
	public ExplicitAbility() {
		super();
		setName("Explicit Ability");
		this.keyBinding = null;
	}
	
	public ExplicitAbility(char keyToBind) {
		super();
		setName("Explicit Ability");
		this.keyBinding = new KeyBinding(keyToBind, this);
	}
	
	public void perform() {
		System.out.println("ALLAHU ACKBAR");
	}
	
	public void attachToController(ControllerAvatar controlAvatar) {
		controlAvatar.addToKLSet(keyBinding);
	}
	public KeyBinding getKeyBinding() {
		return keyBinding;
	}

	public void setKeyBinding(KeyBinding keyBinding) {
		this.keyBinding = keyBinding;
	}

}
