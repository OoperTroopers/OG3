package model.items;

import model.equipmentmanagers.SmasherEquipmentManager;
import model.inventory.Inventory;

public class OneHanded extends Weapon {
	public void equip(SmasherEquipmentManager em, Inventory inventory) {
		em.equipOneHandedWeapon(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(SmasherEquipmentManager em, Inventory inventory) {
		em.unequipOneHandedWeapon();
		inventory.addToInventory(this);
	}
}
