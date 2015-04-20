package model.items;

import view.modelview.tileable.items.TwoHandedView;
import model.effects.Effect;
import model.entities.Entity;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SmasherEquipmentManager;
import model.inventory.Inventory;
import model.map.Tileable;
import model.statistics.EquippableStatistics;

public class TwoHanded extends Weapon {
	public TwoHanded() {
		super("TwoHanded", new TwoHandedView());
	}
	
	public TwoHanded(String name, String description, String id, int value, EquippableStatistics es) {
		super(name, description, id, value, es);
	}

	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);
	}
	
	@Override
	public Tileable clone() {
		return new TwoHanded();
	}
	
	@Override
	public void equip(EquipmentManager em, Inventory inventory) {
		em.unequipTwoHandedWeapon();
		em.equipTwoHandedWeapon(this);
		inventory.removeFromInventory(this);
		
	}
	@Override
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipTwoHandedWeapon();
		inventory.addToInventory(this);
		
	}
}
