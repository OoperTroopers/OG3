package model.items;

import model.effects.Effect;
import model.entities.Entity;
import model.map.Tile;
import model.map.Tileable;

public class Door extends InteractiveItem {

	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);
	}

	@Override
	public boolean isTraversable() {
		return false;
	}

	@Override
	public void interact(Entity entity) {
		// open door / remove door from map
	}

	@Override
	public boolean isInteractive(Entity entity) {
		// if Entity has a key, return true
		return true;
	}

	@Override
	public boolean isPassable() {
		return false;
	}

	@Override
	public Tileable clone() {
		return new Door();
	}

}
