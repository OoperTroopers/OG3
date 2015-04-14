package model.items;

import model.equipmentmanagers.MountEquipmentManager;
import model.inventory.Inventory;

public class Saddle extends Armor {
	public void equip(MountEquipmentManager em, Inventory inventory) {
		em.equipSaddle(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(MountEquipmentManager em, Inventory inventory) {
		em.unequipSaddle();
		inventory.addToInventory(this);
	}
}
