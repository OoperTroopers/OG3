package model.items;

import model.entities.Entity;

public abstract class TakeableItem extends Item {
	private int value;

	public TakeableItem() {
		super();
		this.value = 20;
	}
	
	public TakeableItem(String name, String description, String id, int value) {
		super(name, description, id);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setalue(int value) {
		this.value = value;
	}

	public boolean isPassable() {
		return true;
	}
	
	public void touch() {
		//add to inventory
	}
	
	public void addToInventory(Entity e) {
		//add to inventory
	}
	
	public void removeFromInventory(Entity e) {
		//remove from inventory
	}
	
	public void dropFromInventory(Entity e) {
		//drop from inventory
	}
}
