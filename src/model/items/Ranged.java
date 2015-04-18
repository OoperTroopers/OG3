package model.items;

import model.effects.Effect;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SneakEquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.EquippableStatistics;
public class Ranged extends Weapon {
	public Ranged() {
		super();
	}
	public Ranged(String name, String description, String id, int value, EquippableStatistics es) {
		super(name, description, id, value, es);
	}
	public void equip(SneakEquipmentManager em, Inventory inventory) {
		em.unequipRangedWeapon();
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
	@Override
	public void touch(Entity entity) {
		// TODO Auto-generated method stub
		
	}
}
