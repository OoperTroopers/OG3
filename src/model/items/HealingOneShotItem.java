package model.items;

import view.modelview.tileable.items.HealingOneShotItemView;
import model.effects.Effect;
import model.effects.HealEffect;
import model.entities.Entity;
import model.map.Tile;

public class HealingOneShotItem extends OneShotItem {

	public HealingOneShotItem() {
		super(new HealingOneShotItemView());
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
