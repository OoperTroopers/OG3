package model.items;

import view.modelview.tileable.items.HelmetView;
import model.effects.Effect;
import model.entities.Avatar;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.EquippableStatistics;

public class Helmet extends Armor {
	public Helmet() {
		super("Helmet", new HelmetView());
	}
	
	public Helmet(String name, String description, String id, int value, EquippableStatistics es) {
		super("Helmet", description, id, value, es);
	}
	
	public void equip(EquipmentManager em, Inventory inventory) {
		em.unequipHelmet();
		em.equipHelmet(this);
		inventory.removeFromInventory(this);
	}
	
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipHelmet();
		inventory.addToInventory(this);
	}
	
	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);
	}
	
	@Override
	public Tileable clone() {
		return new Helmet();
	}

	@Override
	public void getClickedByAvatar(Avatar avatar) {
		avatar.fromInventory(this);
	}
}
