package model.items;

import model.equipmentmanagers.SneakEquipmentManager;
import model.inventory.Inventory;

public class Ranged extends Weapon {
	public void equip(SneakEquipmentManager em, Inventory inventory) {
		em.equipRangedWeapon(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(SneakEquipmentManager em, Inventory inventory) {
		em.unequipRangedWeapon();
		inventory.addToInventory(this);
	}
}
