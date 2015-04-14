package model.items;

import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;

public class Chest extends Armor {
	public void equip(EquipmentManager em, Inventory inventory) {
		em.equipChest(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipChest();
		inventory.addToInventory(this);
	}
}
