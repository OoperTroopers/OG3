package model.items;

import model.entities.Entity;

public abstract class InteractiveItem extends Item {
	
	public void touch(Entity entity) {
		
		if (isInteractive(entity)) {
			interact(entity);
		}
		
	}
	
	public abstract void interact(Entity entity);
	public abstract boolean isInteractive(Entity entity);

}
