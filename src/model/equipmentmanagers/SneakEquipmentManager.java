package model.equipmentmanagers;

import model.items.Arms;
import model.items.Chest;
import model.items.Helmet;
import model.items.Legs;
import model.items.Ranged;
import model.statistics.DerivedStatistics;

public class SneakEquipmentManager extends EquipmentManager {
	private Ranged rangedWeapon;
	
	public SneakEquipmentManager() {
		super();
		this.rangedWeapon = null;
	}
	
	public SneakEquipmentManager(DerivedStatistics derivedStats) {
		super(derivedStats);
		this.rangedWeapon = null;
	}
	
	public SneakEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs, Ranged rangedWeapon,
			DerivedStatistics derivedStats) {
		super(helmet, chest, arms, legs, derivedStats);
		this.rangedWeapon = rangedWeapon;
	}
	
	public void equipRangedWeapon(Ranged rangedWeapon) {
		this.rangedWeapon = rangedWeapon;
		getDerivedStats().addEquippable(rangedWeapon.getEquipStats());
	}
	
	public void unequipRangedWeapon() {
		if(rangedWeapon != null) {
			getDerivedStats().removeEquippable(rangedWeapon.getEquipStats());
		}
		rangedWeapon = null;
	}
	
	public Ranged getRangedWeapon() {
		return rangedWeapon;
	}
}
