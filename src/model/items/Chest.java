package model.items;

import view.modelview.tileable.items.ChestView;
import model.effects.Effect;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.map.Tileable;
import model.statistics.EquippableStatistics;

public class Chest extends Armor {
	public Chest() {
		super("Chest", new ChestView());
	}
	
	public Chest(String name, String description, String id, int value, EquippableStatistics es) {
		super("Chest", description, id, value, es);
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
		e.visit(this);
	}
	
	@Override
	public Tileable clone() {
		return new Chest();
	}
}
