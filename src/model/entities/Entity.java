package model.entities;

import model.inventory.Inventory;
import model.equipmentmanagers.*;
import model.occupations.*;
import model.statistics.*;
import model.items.TakeableItem;

import java.util.ArrayList;
import model.map.Tileable;

public abstract class Entity implements Tileable{
	private Inventory inventory;
	private EquipmentManager equipmentMangaer;
	private Occupation occupation;
	private Statistics stats;
	private int direction;
	//private Location location;
	
	// generic constructor creates Smasher as base class
	public Entity() {
		this.inventory = new Inventory();
		this.equipmentMangaer = new SmasherEquipmentManager();
		this.occupation = new SmasherOccupation();
		this.stats = new SmasherStatistics();
		this.direction = 8;
		//this.location = new Location();
	}
	
	// constructor for Entity with specific occupation
	public Entity(Occupation o, EquipmentManager em, Statistics s) {
		this.inventory = new Inventory();
		this.equipmentMangaer = em;
		this.occupation = o;
		this.stats = s;
		this.direction = 8;
		//this.location = new Location();
	}
	
	public void receiveDamage(int amount) {
		//send damage to stats to modify health
	}

	public int sendDamage() {
		//send offensive damage to location
		return 0;
	}
	
	public void changeLocation(int x, int y) {
		//modify location
	}
	
	public void addItemToInventory(TakeableItem item) {
		inventory.addToInventory(item);
	}
	
	public void dropItem(TakeableItem item) {
		inventory.dropFromInventory(item);
	}
	
	public void removeItem(TakeableItem item) {
		inventory.removeFromInventory(item);
	}
	
	public ArrayList<TakeableItem> getAllItems() {
		return inventory.getInventory();
	}

	public TakeableItem getItemFromInvnetory(TakeableItem item) {
		if(inventory.itemInInventory(item)) {
			return item;
		} else {
			return null;
		}
	}

	public void dialogue() {
		//do dialogue
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public EquipmentManager getEquipmentMangaer() {
		return equipmentMangaer;
	}

	public void setEquipmentMangaer(EquipmentManager equipmentMangaer) {
		this.equipmentMangaer = equipmentMangaer;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public Statistics getStats() {
		return stats;
	}

	public void setStats(Statistics stats) {
		this.stats = stats;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
}
