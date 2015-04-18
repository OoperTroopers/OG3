package model.abilities;

public class BindWounds extends ExplicitAbility {
	public BindWounds() {
		super();
		setName("Bind Wounds");
	}
	
	public BindWounds(char keyToBind) {
		super(keyToBind);
		setName("Bind Wounds");
	}
}
