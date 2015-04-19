package model.abilities;

import model.effects.Effect;
import model.entities.Entity;

public class Enchantment extends ExplicitAbility {
	public Enchantment() {
		super();
		setName("Enchantment");
		//setEffect(effect);
	}
	
	public Enchantment(char keyToBind, Effect effect) {
		super(keyToBind);
		setName("Enchantment");
		setEffect(effect);
	}
	
	public void perform(Entity entity) {
		System.out.println("ALLAHU ACKBAR");
		getEffect().visit(entity);
	}
}
