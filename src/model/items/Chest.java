package model.items;

import model.effects.Effect;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.EquippableStatistics;

public class Chest extends Armor {
	public Chest() {
		super();
	}
	public Chest(String name, String description, String id, int value, EquippableStatistics es) {
		super(name, description, id, value, es);
	}
	public void equip(EquipmentManager em, Inventory inventory) {
		em.unequipChest();
		em.equipChest(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipChest();
		inventory.addToInventory(this);
	}
	@Override
	public void acceptEffect(Effect e) {
		// TODO Auto-generated method stub
		
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
	public void touch(Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
