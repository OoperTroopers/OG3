package model.items;

import model.effects.Effect;
import model.effects.HealEffect;
import model.entities.Entity;
import model.map.Tile;
import model.map.Tileable;

public class Potion extends TakeableItem implements Usable{
	private HealEffect healEffect;
	
	public Potion() {
		super();
		healEffect = new HealEffect();
	}
	public Potion(String name, String description, String id, int value) {
		super(name, description, id, value);
		healEffect = new HealEffect();
	}
	
	public void use(Entity entity){
		healEffect.visit(entity);
		entity.removeItem(this);
	}

	@Override
	public void acceptEffect(Effect e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tileable clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTraversable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void touch(Entity entity) {
		// TODO Auto-generated method stub
		
	}
}
