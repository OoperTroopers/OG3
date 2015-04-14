package model.items;

import model.equipmentmanagers.SmasherEquipmentManager;
import model.inventory.Inventory;

public class Shield extends Armor {
	public void equip(SmasherEquipmentManager em, Inventory inventory) {
		em.equipShield(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(SmasherEquipmentManager em, Inventory inventory) {
		em.unequipShield();
		inventory.addToInventory(this);
	}
}
