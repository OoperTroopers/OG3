package model.items;

import view.modelview.tileable.TileableView;
import model.entities.Entity;

public abstract class TakeableItem extends Item {
	private int value;

	public TakeableItem(TileableView itemView) {
		super(itemView);
		this.value = 20;
	}
	
	public TakeableItem(String name, String description, String id, int value) {
		super(name, description, id);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public boolean isPassable() {
		return true;
	}
	
	public void touch(Entity entity) {
		entity.addItemToInventory(this);
		entity.getTile().removeTileable(this);
		System.out.println("TOUCHED");
	}
}
