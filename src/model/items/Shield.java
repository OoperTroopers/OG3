package model.items;

import view.modelview.tileable.items.ShieldView;
import model.effects.Effect;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SmasherEquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.EquippableStatistics;

public class Shield extends Armor {
	public Shield() {
		super("Shield", new ShieldView());
	}
	public Shield(String name, String description, String id, int value, EquippableStatistics es) {
		super("Shield", description, id, value, es);
	}
	public void equip(EquipmentManager em, Inventory inventory) {
		em.unequipShield();
		em.equipShield(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipShield();
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
}
