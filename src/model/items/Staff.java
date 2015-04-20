package model.items;

import view.modelview.tileable.items.StaffView;
import model.effects.Effect;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SmasherEquipmentManager;
import model.equipmentmanagers.SummonerEquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.EquippableStatistics;

public class Staff extends Weapon {
	public Staff() {
		super("Staff", new StaffView());
	}
	
	public Staff(String name, String description, String id, int value, EquippableStatistics es) {
		super("Staff", description, id, value, es);
	}

	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);
	}
	
	@Override
	public Tileable clone() {
		return new Staff();
	}
	
	@Override
	public void equip(EquipmentManager em, Inventory inventory) {
		em.unequipStaff();
		em.equipStaff(this);
		inventory.removeFromInventory(this);
		
	}
	@Override
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipStaff();
		inventory.addToInventory(this);
	}
	
	public String toString() {
		return "Item=Staff";
	}
}
