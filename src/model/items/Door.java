package model.items;

import view.modelview.tileable.items.DoorView;
import model.effects.Effect;
import model.entities.Entity;
import model.map.Tileable;

public class Door extends InteractiveItem {

	public Door() {
		super(new DoorView());
	}

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
