package model.items;

import model.statistics.EquippableStatistics;
import model.equipmentmanagers.EquipmentManager;

public abstract class Armor extends TakeableItem implements Equippable {
	private EquippableStatistics equipStats;
	
	public Armor() {
		super();
		this.equipStats = new EquippableStatistics();
	}
	
	public Armor(String name, String description, String id, int value, EquippableStatistics es) {
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
