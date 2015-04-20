package model.abilities;

import model.effects.Effect;
import model.effects.Fireball;
import model.entities.Entity;
import model.entities.Avatar;

public class Bane extends ExplicitAbility {
	
	private Avatar a;
	public Bane(Avatar a, char keyToBind) {
		super(keyToBind);
		this.a = a;
		setName("Bane");
		setEffect(new Fireball());
	}
	
	public Bane(char keyToBind, Effect effect) {
		super(keyToBind);
		setName("Bane");
		setEffect(effect);
	}
	
	public void perform() {
		a.sendDamageRanged();
	}
}
