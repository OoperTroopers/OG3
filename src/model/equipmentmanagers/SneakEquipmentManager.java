package model.equipmentmanagers;

import model.items.Arms;
import model.items.Chest;
import model.items.Helmet;
import model.items.Legs;
import model.items.Ranged;

public class SneakEquipmentManager extends EquipmentManager {
	private Ranged rangedWeapon;
	
	public SneakEquipmentManager() {
		super();
		this.rangedWeapon = null;
	}
	
	public SneakEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs, Ranged rangedWeapon) {
		super(helmet, chest, arms, legs);
		this.rangedWeapon = rangedWeapon;
	}
	
	public void equipRangedWeapon(Ranged rangedWeapon) {
		this.rangedWeapon = rangedWeapon;
	}
	
	public void unequipRangedWeapon() {
		rangedWeapon = null;
	}
	
	public Ranged getRangedWeapon() {
		return rangedWeapon;
	}
}
