package model.items;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;

public class Arms extends Armor {
	public void equip(EquipmentManager em, Inventory inventory) {
		em.equipArms(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipArms();
		inventory.addToInventory(this);
	}
}
