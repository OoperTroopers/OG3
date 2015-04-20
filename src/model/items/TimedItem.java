package model.items;

import model.effects.Effect;
import model.effects.FrostbiteEffect;
import model.effects.TimedEffect;
import model.entities.Entity;
import model.map.Tileable;
import view.modelview.tileable.TileableView;
import view.modelview.tileable.items.IcicleView;

public abstract class TimedItem extends Item {

	TimedEffect timedEffect;
	int occurrences;
	
	public TimedItem(TileableView itemView) {
		super(itemView);
	}
	
	public TimedItem(TileableView itemView, TimedEffect timedEffect) {
		super(itemView);
		this.timedEffect = timedEffect;
	}

	public TimedItem(TileableView itemView, TimedEffect timedEffect,
			int occurrences) {
		super(itemView);
		this.timedEffect = timedEffect;
		this.occurrences = occurrences;
	}

	@Override
	public void acceptEffect(Effect e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTraversable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPassable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void touch(Entity entity) {
		// TODO Auto-generated method stub
		timedEffect.visit(entity);
	}

	@Override
	public Tileable clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
