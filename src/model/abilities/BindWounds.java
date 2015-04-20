package model.abilities;

import model.effects.Fireball;
import model.effects.HealEffect;
import model.entities.Avatar;
import model.entities.Entity;

public class BindWounds extends ExplicitAbility {
	private Avatar a;
	public BindWounds(Avatar a, char keyToBind) {
		super(keyToBind);
		this.a = a;
		setName("Boon");
	}
	
	
	public BindWounds() {
		super();
		setName("Bind Wounds");
		setEffect(new HealEffect());
	}
	
	public void perform() {
			a.bind();
	}
}
