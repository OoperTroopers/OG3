package model.abilities;

import model.entities.Entity;

public class Pickpocket extends ExplicitAbility {
	public Pickpocket() {
		super();
		setName("Pickpocket");
		//setEffect(effect);
	}
	
	public Pickpocket(char keyToBind) {
		super(keyToBind);
		setName("Pickpocket");
		//setEffect(effect);
	}
	
	public void perform(Entity entity) {
		//access entity inventory and steal
		getEffect().visit(entity);
	}
}
