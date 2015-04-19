package model.items;

import view.modelview.tileable.items.DamagingOneShotItemView;
import model.effects.DamageEffect;
import model.effects.Effect;
import model.map.Tile;

public class DamagingOneShotItem extends OneShotItem {

	public DamagingOneShotItem() {
		super(new DamagingOneShotItemView(), new DamageEffect());
	}
	
	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);		
	}

	@Override
	public Item clone() {
		return new DamagingOneShotItem();
	}	
}