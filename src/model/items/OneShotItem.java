package model.items;

import view.modelview.tileable.TileableView;
import model.effects.Effect;
import model.entities.Entity;

public abstract class OneShotItem extends Item {

	private Effect effect;
	
	public OneShotItem(TileableView tileableView, Effect effect) {
		super(tileableView);
		this.effect = effect;
	}
	
	@Override
	public void touch(Entity entity) {
		effect.visit(entity);
		entity.getTile().removeTileable(this);
		System.out.println("ONE SHOT ITEM TOUCHED");
	}
	
	@Override
	public boolean isPassable() {
		return true;
	}
	
	@Override
	public boolean isTraversable() {
		return true;
	}
	
}
