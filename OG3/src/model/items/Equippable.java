package model.items;

import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;

public interface Equippable {
	public void equip(EquipmentManager em, Inventory i);

	public void unequip(EquipmentManager em, Inventory i);
}
