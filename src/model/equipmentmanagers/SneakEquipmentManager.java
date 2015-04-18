package model.equipmentmanagers;

import model.items.Arms;
import model.items.Chest;
import model.items.Helmet;
import model.items.Legs;
import model.items.Ranged;
import model.occupations.Occupation;
import model.occupations.SneakOccupation;
import model.statistics.DerivedStatistics;

public class SneakEquipmentManager extends EquipmentManager {
	private Ranged rangedWeapon;
	
	public SneakEquipmentManager() {
		super();
		this.rangedWeapon = null;
	}
	
	public SneakEquipmentManager(DerivedStatistics derivedStats, Occupation occupation) {
		super(derivedStats, occupation);
		this.rangedWeapon = null;
	}
	
	public SneakEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs, Ranged rangedWeapon,
			DerivedStatistics derivedStats, Occupation occupation) {
		super(helmet, chest, arms, legs, derivedStats, occupation);
		this.rangedWeapon = rangedWeapon;
	}
	
	public void equipRangedWeapon(Ranged rangedWeapon) {
		this.rangedWeapon = rangedWeapon;
		getDerivedStats().addEquippable(rangedWeapon.getEquipStats());
		getDerivedStats().addAbilityLevel(((SneakOccupation)getOccupation()).getRangedAbilityLevel());
	}
	
	public void unequipRangedWeapon() {
		if(rangedWeapon != null) {
			getDerivedStats().removeEquippable(rangedWeapon.getEquipStats());
			getDerivedStats().removeAbilityLevel(((SneakOccupation)getOccupation()).getRangedAbilityLevel());
		}
		rangedWeapon = null;
	}
	
	public Ranged getRangedWeapon() {
		return rangedWeapon;
	}
}
