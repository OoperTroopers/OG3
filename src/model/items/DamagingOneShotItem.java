package model.items;

import model.effects.DamageEffect;
import model.effects.Effect;
import model.map.Tile;

public class DamagingOneShotItem extends OneShotItem {

	public DamagingOneShotItem() {
		super(new DamageEffect());
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
		return new DamagingOneShotItem();
	}	
}