package model.equipmentmanagers;

import model.inventory.Inventory;
import model.items.Arms;
import model.items.Chest;
import model.items.Helmet;
import model.items.Legs;
import model.items.Shield;
import model.items.OneHanded;
import model.items.TwoHanded;
import model.items.Brawl;

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
	
	public SmasherEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs, Brawl bhw) {
		super(helmet, chest, arms, legs);
		this.bareHandedWeapon = bhw;
		this.shield = null;
		this.twoHandedWeapon = null;
		this.oneHandedWeapon = null;
	}
	
	public SmasherEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs, TwoHanded thw) {
		super(helmet, chest, arms, legs);
		this.twoHandedWeapon = thw;
		this.shield = null;
		this.oneHandedWeapon = null;
		this.bareHandedWeapon = null;
	}
	
	public SmasherEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs, Shield s, OneHanded ohw) {
		super(helmet, chest, arms, legs);
		this.shield = s;
		this.oneHandedWeapon = ohw;
		this.twoHandedWeapon = null;
		this.bareHandedWeapon = null;
	}
	
	public void equipShield(Shield shield) {
		this.shield = shield;
	}
	
	public void equipTwoHandedWeapon(TwoHanded twoHandedWeapon) {
		this.twoHandedWeapon = twoHandedWeapon;
	}
	
	public void equipOneHandedWeapon(OneHanded oneHandedWeapon) {
		this.oneHandedWeapon = oneHandedWeapon;
	}
	
	public void equipBareHandedWeapon(Brawl bareHandedWeapon) {
		this.bareHandedWeapon = bareHandedWeapon;
	}
	
	public void unequipShield(Inventory inventory) {
		inventory.addToInventory(shield);
		shield = null;
	}
	
	public void unequipequipTwoHandedWeapon(Inventory inventory) {
		inventory.addToInventory(twoHandedWeapon);
		twoHandedWeapon = null;
	}
	
	public void unequipOneHandedWeapon(Inventory inventory) {
		inventory.addToInventory(oneHandedWeapon);
		oneHandedWeapon = null;
	}
	
	public void unequipBareHandedWeapon(Inventory inventory) {
		inventory.addToInventory(bareHandedWeapon);
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
