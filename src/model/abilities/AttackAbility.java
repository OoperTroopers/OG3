package model.abilities;

import model.effects.Effect;
import model.effects.Fireball;
import model.entities.Entity;
import model.entities.Avatar;

public class AttackAbility extends ExplicitAbility {
	private Avatar a;
	public AttackAbility() {
		super();
		setName("Bane");
		setEffect(new Fireball());
	}
	
	public AttackAbility(Avatar a, char keyToBind) {
		super(keyToBind);
		setName("Bane");
		this.a = a;
		setEffect(new Fireball());
	}
	
	public AttackAbility(Avatar a, char keyToBind, Effect effect) {
		super(keyToBind);
		setName("Bane");
		setEffect(effect);
	}
	
	public void perform() {
		a.sendDamage();
	}
}
