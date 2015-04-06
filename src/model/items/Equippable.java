package model.items;

import equipmentmanagers.EquipmentManager;

public interface Equippable {
	public void equip(EquipmentManager em);

	public void unequip(EquipmentManager em);
}
