package model.items;

import model.equipmentmanagers.EquipmentManager;

public interface Equippable {
	public void equip(EquipmentManager em);

	public void unequip(EquipmentManager em);
}
