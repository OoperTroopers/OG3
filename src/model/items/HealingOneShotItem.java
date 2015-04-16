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
	public void removeFromTile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tile getContainingTile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item clone() {
		return new HealingOneShotItem();
	}	
}
