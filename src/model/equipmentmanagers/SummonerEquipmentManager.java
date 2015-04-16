package model.equipmentmanagers;

import model.items.Arms;
import model.items.Chest;
import model.items.Helmet;
import model.items.Legs;
import model.items.Staff;
import model.statistics.DerivedStatistics;

public class SummonerEquipmentManager extends EquipmentManager {
	private Staff staff;

	public SummonerEquipmentManager() {
		super();
		this.staff = null;
	}
	
	public SummonerEquipmentManager(DerivedStatistics derivedStats) {
		super(derivedStats);
		this.staff = null;
	}
	
	public SummonerEquipmentManager(Helmet helmet, Chest chest, Arms arms, 
			Legs legs, Staff staff, DerivedStatistics derivedStats) {
		super(helmet, chest, arms, legs, derivedStats);
		this.staff = staff;
	}
	
	public void equipStaff(Staff staff) {
		this.staff = staff;
		getDerivedStats().addEquippable(staff.getEquipStats());
	}
	
	public void unequipStaff() {
		getDerivedStats().removeEquippable(staff.getEquipStats());
		staff= null;
	}
	
	public Staff getStaff() {
		return staff;
	}
}
