package model.inventory;

import model.items.TakeableItem;

import java.util.ArrayList;

import view.view.ActiveGameViewport;

public class Inventory {
	private ArrayList<TakeableItem> inventory;
	
	public Inventory() {
		this.inventory = new ArrayList<TakeableItem>();
	}
	
	public void addToInventory(TakeableItem item) {
		System.out.println("ITEM HAS BEEN ADDED!");
		inventory.add(item);
		notifyGameView();
	}
	
	public void dropFromInventory(TakeableItem item) {
		inventory.remove(item);
		notifyGameView();
	}
	
	public void removeFromInventory(TakeableItem item) {
		inventory.remove(item);
		notifyGameView();
	}
	
	public ArrayList<TakeableItem> getInventory(){
		return inventory;
	}
	
	public boolean itemInInventory(TakeableItem item) {
		return inventory.contains(item);
	}
	
	public String toString() {
		String s = "";
		for (TakeableItem takeableItem : inventory)
			s += takeableItem.getName() + "\n";
		return s;
	}
	
	public void notifyGameView() {
		ActiveGameViewport.getInstance().updateInventory(this);
	}
}
