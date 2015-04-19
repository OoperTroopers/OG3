package model.abilities;

import model.effects.HealEffect;
import model.entities.Entity;

public class BindWounds extends ExplicitAbility {
	public BindWounds() {
		super();
		setName("Bind Wounds");
		setEffect(new HealEffect());
	}
	
	public BindWounds(char keyToBind) {
		super(keyToBind);
		setName("Bind Wounds");
		setEffect(new HealEffect());
	}
	
	public void perform(Entity entity) {
		System.out.println("ALLAHU ACKBAR");
		getEffect().visit(entity);
	}
}
