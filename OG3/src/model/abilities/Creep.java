package model.abilities;

import model.entities.Entity;

public class Creep extends ExplicitAbility {
	public Creep() {
		super();
		setName("Creep");
		//setEffect(effect);
	}
	
	public Creep(char keyToBind) {
		super(keyToBind);
		setName("Creep");
		//setEffect(effect);
	}
	
	public void perform(Entity entity) {
		System.out.println("ALLAHU ACKBAR");
		//reduce visibility by enemies
		getEffect().visit(entity);
	}
}
