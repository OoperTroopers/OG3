package model.items;

import model.effects.Effect;
import model.entities.Entity;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.Statistics;

public class Potion extends TakeableItem implements Usable{
	public void use(Statistics stats){
		stats.fullRestore();
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
