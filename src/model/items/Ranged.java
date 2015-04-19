package model.items;

import view.modelview.tileable.items.RangedView;
import model.effects.Effect;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SmasherEquipmentManager;
import model.equipmentmanagers.SneakEquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.EquippableStatistics;
public class Ranged extends Weapon {
	public Ranged() {
		super(new RangedView());
	}
	public Ranged(String name, String description, String id, int value, EquippableStatistics es) {
		super(name, description, id, value, es);
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
	public void equip(EquipmentManager em, Inventory inventory) {
		((SneakEquipmentManager)em).unequipRangedWeapon();
		((SneakEquipmentManager)em).equipRangedWeapon(this);
		inventory.removeFromInventory(this);
		
	}
	@Override
	public void unequip(EquipmentManager em, Inventory inventory) {
		((SneakEquipmentManager)em).unequipRangedWeapon();
		inventory.addToInventory(this);
	}
}
