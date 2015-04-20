package model.items;

import view.modelview.tileable.items.BrawlView;
import model.effects.Effect;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SmasherEquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.EquippableStatistics;
public class Brawl extends Weapon {
	public Brawl() {
		super("Brawl", new BrawlView());
	}
	public Brawl(String name, String description, String id, int value, EquippableStatistics es) {
		super("Brawl", description, id, value, es);
	}
	
	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);
	}
	
	@Override
	public Tileable clone() {
		return new Brawl();
	}
	
	@Override
	public void equip(EquipmentManager em, Inventory inventory) {
		em.unequipBareHandedWeapon();
		em.equipBareHandedWeapon(this);
		inventory.removeFromInventory(this);
		
	}
	@Override
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipBareHandedWeapon();
		inventory.addToInventory(this);
	}
	
	public String toString() {
		return "Item=Brawl";
	}
}
