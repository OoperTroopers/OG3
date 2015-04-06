package model.equipmentmanagers;

import model.items.*;

public abstract class EquipmentManager {
	private Helmet helmet;
	private Chest chest;
	private Arms arms;
	private Legs legs;
	
	public EquipmentManager() {
		this.helmet = null;
		this.chest = null;
		this.arms = null;
		this.legs = null;
	}
	
	public EquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs) {
		this.helmet = helmet;
		this.chest = chest;
		this.arms = arms;
		this.legs = legs;
	}
	
	public void equipHelmet(Helmet helmet) {
		this.helmet = helmet;
	}
	
	public void equipChest(Chest chest) {
		this.chest = chest;
	}
	
	public void equipArms(Arms arms) {
		this.arms = arms;
	}
	
	public void equipLegs(Legs legs) {
		this.legs = legs;
	}
}
