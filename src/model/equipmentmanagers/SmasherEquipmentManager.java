package model.equipmentmanagers;

import model.items.Arms;
import model.items.Chest;
import model.items.Helmet;
import model.items.Legs;
import model.items.Shield;
import model.items.OneHanded;
import model.items.TwoHanded;
import model.items.Brawl;
import model.statistics.DerivedStatistics;
import model.occupations.Occupation;

public class SmasherEquipmentManager extends EquipmentManager {
	private Shield shield;
	private TwoHanded twoHandedWeapon;
	private OneHanded oneHandedWeapon;
	private Brawl bareHandedWeapon;
	
	public SmasherEquipmentManager() {
		super();
		this.shield = null;
		this.twoHandedWeapon = null;
		this.oneHandedWeapon = null;
		this.bareHandedWeapon = null;
	}
	
	public SmasherEquipmentManager(DerivedStatistics derivedStats, Occupation occupation) {
		super(derivedStats, occupation);
		this.shield = null;
		this.twoHandedWeapon = null;
		this.oneHandedWeapon = null;
		this.bareHandedWeapon = null;
	}
	
	public SmasherEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs,
			Brawl bhw, DerivedStatistics derivedStats, Occupation occupation) {
		super(helmet, chest, arms, legs, derivedStats, occupation);
		this.bareHandedWeapon = bhw;
		this.shield = null;
		this.twoHandedWeapon = null;
		this.oneHandedWeapon = null;
	}
	
	public SmasherEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs,
			TwoHanded thw, DerivedStatistics derivedStats, Occupation occupation) {
		super(helmet, chest, arms, legs, derivedStats, occupation);
		this.twoHandedWeapon = thw;
		this.shield = null;
		this.oneHandedWeapon = null;
		this.bareHandedWeapon = null;
	}
	
	public SmasherEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs,
			Shield s, OneHanded ohw, DerivedStatistics derivedStats, Occupation occupation) {
		super(helmet, chest, arms, legs, derivedStats, occupation);
		this.shield = s;
		this.oneHandedWeapon = ohw;
		this.twoHandedWeapon = null;
		this.bareHandedWeapon = null;
	}
	
	public void equipShield(Shield shield) {
		this.shield = shield;
		getDerivedStats().addEquippable(shield.getEquipStats());
	}
	
	public void equipTwoHandedWeapon(TwoHanded twoHandedWeapon) {
		this.twoHandedWeapon = twoHandedWeapon;
		getDerivedStats().addEquippable(twoHandedWeapon.getEquipStats());
	}
	
	public void equipOneHandedWeapon(OneHanded oneHandedWeapon) {
		this.oneHandedWeapon = oneHandedWeapon;
		//int statBoost = oneHandedWeapon.getEquipStats() + getOccupation().getOneHandedAbilityLevel();
		getDerivedStats().addEquippable(oneHandedWeapon.getEquipStats());
	}
	
	public void equipBareHandedWeapon(Brawl bareHandedWeapon) {
		this.bareHandedWeapon = bareHandedWeapon;
		getDerivedStats().addEquippable(bareHandedWeapon.getEquipStats());
	}
	
	public void unequipShield() {
		if(shield != null) {
			getDerivedStats().removeEquippable(shield.getEquipStats());
		}
		shield = null;
	}
	
	public void unequipTwoHandedWeapon() {
		if(twoHandedWeapon != null) {
			getDerivedStats().removeEquippable(twoHandedWeapon.getEquipStats());
		}
		twoHandedWeapon = null;
	}
	
	public void unequipOneHandedWeapon() {
		if(oneHandedWeapon != null) {
			getDerivedStats().removeEquippable(oneHandedWeapon.getEquipStats());
		}
		oneHandedWeapon = null;
	}
	
	public void unequipBareHandedWeapon() {
		if(bareHandedWeapon != null) {
			getDerivedStats().removeEquippable(bareHandedWeapon.getEquipStats());
		}
		bareHandedWeapon = null;
	}
	
	public Shield getShield() {
		return shield;
	}
	
	public TwoHanded getTwoHandedWeapon() {
		return twoHandedWeapon;
	}
	
	public OneHanded getOneHandedWeapon() {
		return oneHandedWeapon;
	}
	
	public Brawl getBareHandedWeapon() {
		return bareHandedWeapon;
	}
}
