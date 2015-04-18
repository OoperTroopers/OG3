package model.equipmentmanagers;

import model.items.*;
import model.statistics.DerivedStatistics;
import model.occupations.Occupation;

public abstract class EquipmentManager {
	private Helmet helmet;
	private Chest chest;
	private Arms arms;
	private Legs legs;
	private DerivedStatistics derivedStats;
	private Occupation occupation;
	
	//generic Equipment Manager
	public EquipmentManager() {
		this.helmet = null;
		this.chest = null;
		this.arms = null;
		this.legs = null;
		this.derivedStats = null;
		this.occupation = null;
	}
	
	//new empty Equipment Manager
	public EquipmentManager(DerivedStatistics derivedStats, Occupation occupation) {
		this.helmet = null;
		this.chest = null;
		this.arms = null;
		this.legs = null;
		this.derivedStats = derivedStats;
		this.occupation = occupation;
	}
	
	//new filled equipment manager
	public EquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs,
			DerivedStatistics derivedStats, Occupation occupation) {
		this.helmet = helmet;
		this.chest = chest;
		this.arms = arms;
		this.legs = legs;
		this.derivedStats = derivedStats;
		this.occupation = occupation;
	}
	
	public void equipHelmet(Helmet helmet) {
		this.helmet = helmet;
		derivedStats.addEquippable(helmet.getEquipStats());
	}
	
	public void equipChest(Chest chest) {
		this.chest = chest;
		derivedStats.addEquippable(chest.getEquipStats());
	}
	
	public void equipArms(Arms arms) {
		this.arms = arms;
		derivedStats.addEquippable(helmet.getEquipStats());
	}
	
	public void equipLegs(Legs legs) {
		this.legs = legs;
		derivedStats.addEquippable(legs.getEquipStats());
	}
	
	public void unequipHelmet() {
		if(helmet != null) {
			derivedStats.removeEquippable(helmet.getEquipStats());
		}
			helmet = null; 
	}
	
	public void unequipChest() {
		if(chest != null) {
			derivedStats.removeEquippable(chest.getEquipStats());
		}
		chest = null;
	}
	
	public void unequipArms() {
		if(arms != null) {
			derivedStats.removeEquippable(arms.getEquipStats());
		}
		arms = null;
	}
	
	public void unequipLegs() {
		if(legs != null) {
			derivedStats.removeEquippable(legs.getEquipStats());
		}
		legs = null;
	}
	
	public Helmet getHelmet() {
		return helmet;
	}
	
	public Chest getChest() {
		return chest;
	}
	
	public Arms getArms() {
		return arms;
	}
	
	public Legs getLegs() {
		return legs;
	}
	
	public DerivedStatistics getDerivedStats() {
		return derivedStats;
	}
	
	public void setDerivedStats(DerivedStatistics derivedStats) {
		this.derivedStats = derivedStats;
	}
	public Occupation getOccupation() {
		return occupation;
	}
	
	public void setOccupation(Occupation occupation) {
		this.occupation= occupation;
	}
}
