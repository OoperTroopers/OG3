package model.items;

import view.modelview.tileable.items.SaddleView;
import model.effects.Effect;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.EquippableStatistics;
public class Saddle extends Armor {
	public Saddle() {
		super("Saddle", new SaddleView());
	}
	
	public Saddle(String name, String description, String id, int value, EquippableStatistics es) {
		super("Saddle", description, id, value, es);
	}
	
	public void equip(EquipmentManager em, Inventory inventory) {
		em.unequipSaddle();
		em.equipSaddle(this);
		inventory.removeFromInventory(this);
	}
	
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipSaddle();
		inventory.addToInventory(this);
	}

	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);
	}
	
	@Override
	public Tileable clone() {
		return new Saddle();
	}
	
	public String toString() {
		return "Item=Saddle";
	}
}
