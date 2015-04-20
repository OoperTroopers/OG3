package model.abilities;

import model.effects.Effect;
import model.effects.Fireball;
import model.entities.Avatar;
import model.entities.Entity;

public class Boon extends ExplicitAbility {
	private Avatar a;
	public Boon(Avatar a, char keyToBind) {
		super(keyToBind);
		this.a = a;
		setName("Bane");
		setEffect(new Fireball());
	}
	
	public Boon(char keyToBind, Effect effect) {
		super(keyToBind);
		setName("Bane");
		setEffect(effect);
	}
	
	public void perform() {
		a.sendHeal();
	}
}
