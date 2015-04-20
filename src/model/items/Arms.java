package model.items;

import view.modelview.tileable.items.ArmsView;
import model.effects.Effect;
import model.entities.Avatar;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.EquippableStatistics;
public class Arms extends Armor {
	public Arms() {
		super("Arms", new ArmsView());
	}
	
	public Arms(String name, String description, String id, int value, EquippableStatistics es) {
		super("Armor", description, id, value, es);
	}
	
	public void equip(EquipmentManager em, Inventory inventory) {
		em.unequipArms();
		em.equipArms(this);
		inventory.removeFromInventory(this);
	}
	
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipArms();
		inventory.addToInventory(this);
	}
	
	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);		
	}
	
	@Override
	public Tileable clone() {
		return new Arms();
	}
	
	public String toString() {
		return "Item=Arms";
	}

	@Override
	public void getClickedByAvatar(Avatar avatar) {
		avatar.fromInventory(this);
	}
}
