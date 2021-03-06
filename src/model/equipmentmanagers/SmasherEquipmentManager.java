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
import model.occupations.*;

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
		if(bhw != null) {
			setCurrentSkill("Brawl Ability");
		}
		this.bareHandedWeapon = bhw;
		this.shield = null;
		this.twoHandedWeapon = null;
		this.oneHandedWeapon = null;
	}
	
	public SmasherEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs,
			TwoHanded thw, DerivedStatistics derivedStats, Occupation occupation) {
		super(helmet, chest, arms, legs, derivedStats, occupation);
		if(thw != null) {
			setCurrentSkill("Two Handed Weapon Ability");
		}
		this.twoHandedWeapon = thw;
		this.shield = null;
		this.oneHandedWeapon = null;
		this.bareHandedWeapon = null;
	}
	
	public SmasherEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs,
			Shield s, OneHanded ohw, DerivedStatistics derivedStats, Occupation occupation) {
		super(helmet, chest, arms, legs, derivedStats, occupation);
		if(ohw != null) {
			setCurrentSkill("One Handed Weapon Ability");
		}
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
		setCurrentSkill("Two Handed Weapon Ability");
		getDerivedStats().addEquippable(twoHandedWeapon.getEquipStats());
		getDerivedStats().addAbilityLevel(((SmasherOccupation)getOccupation()).getTwoHandedAbilityLevel());
	}
	
	public void equipOneHandedWeapon(OneHanded oneHandedWeapon) {
		this.oneHandedWeapon = oneHandedWeapon;
		setCurrentSkill("One Handed Weapon Ability");
		getDerivedStats().addEquippable(oneHandedWeapon.getEquipStats());
		getDerivedStats().addAbilityLevel(((SmasherOccupation)getOccupation()).getOneHandedAbilityLevel());
	}
	
	public void equipBareHandedWeapon(Brawl bareHandedWeapon) {
		this.bareHandedWeapon = bareHandedWeapon;
		setCurrentSkill("Brawl Ability");
		getDerivedStats().addEquippable(bareHandedWeapon.getEquipStats());
		getDerivedStats().addAbilityLevel(((SmasherOccupation)getOccupation()).getBrawlAbilityLevel());
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
			getDerivedStats().removeAbilityLevel(((SmasherOccupation)getOccupation()).getTwoHandedAbilityLevel());
		}
		twoHandedWeapon = null;
		setCurrentSkill(null);
	}
	
	public void unequipOneHandedWeapon() {
		if(oneHandedWeapon != null) {
			getDerivedStats().removeEquippable(oneHandedWeapon.getEquipStats());
			getDerivedStats().removeAbilityLevel(((SmasherOccupation)getOccupation()).getOneHandedAbilityLevel());
		}
		oneHandedWeapon = null;
		setCurrentSkill(null);
	}
	
	public void unequipBareHandedWeapon() {
		if(bareHandedWeapon != null) {
			getDerivedStats().removeEquippable(bareHandedWeapon.getEquipStats());
			getDerivedStats().removeAbilityLevel(((SmasherOccupation)getOccupation()).getBrawlAbilityLevel());
		}
		bareHandedWeapon = null;
		setCurrentSkill(null);
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
