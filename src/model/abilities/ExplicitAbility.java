package model.abilities;

import controller.KeyBinding;
import controller.AvatarController;
import model.effects.Effect;

public abstract class ExplicitAbility extends Ability {
	private KeyBinding keyBinding;
	private boolean activated;
	private Effect effect;
	
	public ExplicitAbility() {
		super();
		setName("Explicit Ability");
		this.keyBinding = null;
		this.activated = true;
		this.effect = null;
	}
	
	public ExplicitAbility(char keyToBind) {
		super();
		setName("Explicit Ability");
		this.keyBinding = new KeyBinding(keyToBind, this);
		this.activated = true;
		this.effect = null;
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
	}
	
	public void attachToController(AvatarController controlAvatar) {
		controlAvatar.addToKLSet(keyBinding);
	}
	public KeyBinding getKeyBinding() {
		return keyBinding;
	}
	public void setKeyBinding(KeyBinding keyBinding) {
		this.keyBinding = keyBinding;
	}
	public Effect getEffect() {
		return effect;
	}
	public void setEffect(Effect effect) {
		this.effect = effect;
	}

}
