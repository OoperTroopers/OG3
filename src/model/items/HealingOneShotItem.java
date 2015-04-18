package model.items;

import model.effects.Effect;
import model.effects.HealEffect;
import model.entities.Entity;
import model.map.Tile;

public class HealingOneShotItem extends OneShotItem {

	public HealingOneShotItem() {
		super(new HealEffect());
	}
	
	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);		
	}

	@Override
	public Item clone() {
		return new HealingOneShotItem();
	}	
}
