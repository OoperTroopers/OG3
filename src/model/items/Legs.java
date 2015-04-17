package model.items;

import model.effects.Effect;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;

public class Legs extends Armor {
	public void equip(EquipmentManager em, Inventory inventory) {
		em.equipLegs(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipLegs();
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
	public void touch(Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
