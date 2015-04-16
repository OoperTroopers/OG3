package model.items;

import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.statistics.EquippableStatistics;

public abstract class Weapon extends TakeableItem implements Equippable{
	private EquippableStatistics equipStats;
	
	public Weapon() {
		super();
		this.equipStats = new EquippableStatistics();
	}
	
	public Weapon(String name, String description, String id, int value, EquippableStatistics es) {
		super(name, description, id, value);
		this.equipStats = es;	
	}
	
	public abstract void equip(EquipmentManager em, Inventory i);
	
	public abstract void unequip(EquipmentManager em, Inventory i);
	
	public EquippableStatistics getEquipStats() { 
		return equipStats;
	}
	
	public void setEquipStats(EquippableStatistics es) {
		this.equipStats = es;
	}
}
