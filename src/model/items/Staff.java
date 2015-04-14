package model.items;

import model.equipmentmanagers.SummonerEquipmentManager;
import model.inventory.Inventory;

public class Staff extends Weapon {
	public void equip(SummonerEquipmentManager em, Inventory inventory) {
		em.equipStaff(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(SummonerEquipmentManager em, Inventory inventory) {
		em.unequipStaff();
		inventory.addToInventory(this);
	}
}
