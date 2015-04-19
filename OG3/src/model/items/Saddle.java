package model.items;

import view.modelview.tileable.items.SaddleView;
import model.effects.Effect;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.MountEquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.EquippableStatistics;
public class Saddle extends Armor {
	public Saddle() {
		super(new SaddleView());
	}
	public Saddle(String name, String description, String id, int value, EquippableStatistics es) {
		super(name, description, id, value, es);
	}
	public void equip(MountEquipmentManager em, Inventory inventory) {
		em.unequipSaddle();
		em.equipSaddle(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(MountEquipmentManager em, Inventory inventory) {
		em.unequipSaddle();
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
