package model.items;

import view.modelview.tileable.TileableView;
import model.statistics.EquippableStatistics;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;

public abstract class Armor extends TakeableItem implements Equippable {
	private EquippableStatistics equipStats;
	
	public Armor(TileableView tileableView) {
		super(tileableView);
		this.equipStats = new EquippableStatistics();
	}
	
	public Armor(String name, TileableView tileableView) {
		super(name, tileableView);
		this.equipStats = new EquippableStatistics();
	}
	
	
	public Armor(String name, String description, String id, int value, EquippableStatistics es) {
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
