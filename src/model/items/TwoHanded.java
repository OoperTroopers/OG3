package model.items;

import model.equipmentmanagers.SmasherEquipmentManager;
import model.inventory.Inventory;

public class TwoHanded extends Weapon {
	public void equip(SmasherEquipmentManager em, Inventory inventory) {
		em.equipTwoHandedWeapon(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(SmasherEquipmentManager em, Inventory inventory) {
		em.unequipTwoHandedWeapon();
		inventory.addToInventory(this);
	}
}
