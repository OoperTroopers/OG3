package model.items;

import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;

public class Helmet extends Armor {
	public void equip(EquipmentManager em, Inventory inventory) {
		em.equipHelmet(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipHelmet();
		inventory.addToInventory(this);
	}
}
