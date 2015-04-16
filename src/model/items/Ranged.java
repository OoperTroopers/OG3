package model.items;

import model.effects.Effect;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SneakEquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
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

	@Override
	public void acceptEffect(Effect e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeFromTile() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Tile getContainingTile() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Tileable clone() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isTraversable() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void equip(EquipmentManager em, Inventory i) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unequip(EquipmentManager em, Inventory i) {
		// TODO Auto-generated method stub
		
	}
}
