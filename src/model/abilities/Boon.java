package model.abilities;

import model.effects.Effect;
import model.entities.Entity;

public class Boon extends ExplicitAbility {
	public Boon() {
		super();
		setName("Boon");
		//setEffect(effect);
	}
	
	public Boon(char keyToBind, Effect effect) {
		super(keyToBind);
		setName("Boon");
		setEffect(effect);
	}
	
	public void perform(Entity entity) {
		System.out.println("ALLAHU ACKBAR");
		getEffect().visit(entity);
	}
}
