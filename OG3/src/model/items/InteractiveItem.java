package model.items;

import view.modelview.tileable.TileableView;
import model.entities.Entity;

public abstract class InteractiveItem extends Item {
	
	public InteractiveItem(TileableView tileableView) {
		super(tileableView);
	}
	public void touch(Entity entity) {
		
		if (isInteractive(entity)) {
			interact(entity);
		}
		
	}
	
	public abstract void interact(Entity entity);
	public abstract boolean isInteractive(Entity entity);

}
