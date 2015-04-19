package model.abilities;

import model.effects.Effect;
import model.effects.Fireball;
import model.entities.Entity;

public class Bane extends ExplicitAbility {
	public Bane() {
		super();
		setName("Bane");
		setEffect(new Fireball());
	}
	
	public Bane(char keyToBind, Effect effect) {
		super(keyToBind);
		setName("Bane");
		setEffect(effect);
	}
	
	public void perform(Entity entity) {
		System.out.println("ALLAHU ACKBAR");
		getEffect().visit(entity);
	}
}
