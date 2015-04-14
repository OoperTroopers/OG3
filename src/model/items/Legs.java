package model.items;

import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;

public class Legs extends Armor {
	public void equip(EquipmentManager em, Inventory inventory) {
		em.equipLegs(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipLegs();
		inventory.addToInventory(this);
	}
}
