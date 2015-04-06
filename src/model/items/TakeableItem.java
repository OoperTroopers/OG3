package model.items;

import entities.Entity;

public abstract class TakeableItem extends Item {
	private String name;
	private String description;
	private String id;
	private int value;

	public TakeableItem() {
		super();
		this.value = 0;
	}
	
	public TakeableItem(String name, String description, String id, int value) {
		super(name, description, id);
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
