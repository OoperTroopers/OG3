package model.inventory;

import model.items.TakeableItem;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<TakeableItem> inventory;
	
	public Inventory() {
		this.inventory = new ArrayList<TakeableItem>();
	}
	
	public void addToInventory(TakeableItem item) {
		System.out.println("ITEM HAS BEEN ADDED!");
		inventory.add(item);
	}
	
	public void dropFromInventory(TakeableItem item) {
		inventory.remove(item);
		//place in hashmap at location
	}
	
	public void removeFromInventory(TakeableItem item) {
		inventory.remove(item);
	}
	
	public ArrayList<TakeableItem> getInventory(){
		return inventory;
	}
	
	public boolean itemInInventory(TakeableItem item) {
		boolean exists = inventory.contains(item);
		return exists;
	}
}
