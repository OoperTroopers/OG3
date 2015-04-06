package model.items;

import equipmentmanagers.EquipmentManager;
import statistics.EquippableStatistics;

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
	
	public void equip(EquipmentManager em) {
		//not sure how to implement here
	}
	
	public void unequip(EquipmentManager em) {
		//not sure how to implement here
	}
	
	public EquippableStatistics getEquipStats() { 
		return equipStats;
	}
	
	public void setEquipStats(EquippableStatistics es) {
		this.equipStats = es;
	}
}
