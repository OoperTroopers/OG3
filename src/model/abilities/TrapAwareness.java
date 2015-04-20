package model.abilities;

public class TrapAwareness extends ExplicitAbility {
	public TrapAwareness() {
		super();
		setName("TrapAwareness");
		//setEffect(effect);
	}
	
	public TrapAwareness(char keyToBind) {
		super(keyToBind);
		setName("TrapAwareness");
		//setEffect(effect);
	}
	public void perform() {
		//ping
	}
}
