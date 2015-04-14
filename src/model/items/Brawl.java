package model.items;

import model.equipmentmanagers.SmasherEquipmentManager;
import model.inventory.Inventory;

public class Brawl extends Weapon {
	public void equip(SmasherEquipmentManager em, Inventory inventory) {
		em.equipBareHandedWeapon(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(SmasherEquipmentManager em, Inventory inventory) {
		em.unequipBareHandedWeapon();
		inventory.addToInventory(this);
	}
}
