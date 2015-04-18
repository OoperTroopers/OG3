package model.abilities;

import controller.KeyBinding;
import controller.ControllerAvatar;

public abstract class ExplicitAbility extends Ability {
	private KeyBinding keyBinding;
	private boolean activated;
	
	public ExplicitAbility() {
		super();
		setName("Explicit Ability");
		this.keyBinding = null;
		this.activated = true;
	}
	
	public ExplicitAbility(char keyToBind) {
		super();
		setName("Explicit Ability");
		this.keyBinding = new KeyBinding(keyToBind, this);
		this.activated = true;
	}
	
	public void activate() {
		this.activated = true;
	}
	
	public boolean isActivated() {
		return this.activated;
	}
	
	public void deactivate() {
		this.activated = false;
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
