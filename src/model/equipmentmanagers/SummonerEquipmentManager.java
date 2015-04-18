package model.equipmentmanagers;

import model.items.Arms;
import model.items.Chest;
import model.items.Helmet;
import model.items.Legs;
import model.items.Staff;
import model.occupations.Occupation;
import model.occupations.SummonerOccupation;
import model.statistics.DerivedStatistics;

public class SummonerEquipmentManager extends EquipmentManager {
	private Staff staff;

	public SummonerEquipmentManager() {
		super();
		this.staff = null;
	}
	
	public SummonerEquipmentManager(DerivedStatistics derivedStats, Occupation occupation) {
		super(derivedStats, occupation);
		this.staff = null;
	}
	
	public SummonerEquipmentManager(Helmet helmet, Chest chest, Arms arms, 
			Legs legs, Staff staff, DerivedStatistics derivedStats, Occupation occupation) {
		super(helmet, chest, arms, legs, derivedStats, occupation);
		this.staff = staff;
		setCurrentSkill("Staff Ability");
	}
	
	public void equipStaff(Staff staff) {
		this.staff = staff;
		setCurrentSkill("Staff Ability");
		getDerivedStats().addEquippable(staff.getEquipStats());
		getDerivedStats().addAbilityLevel(((SummonerOccupation)getOccupation()).getStaffAbilityLevel());
	}
	
	public void unequipStaff() {
		if(staff != null) {
			getDerivedStats().removeEquippable(staff.getEquipStats());
			getDerivedStats().removeAbilityLevel(((SummonerOccupation)getOccupation()).getStaffAbilityLevel());
		}
		staff= null;

		setCurrentSkill(null);
	}
	
	public Staff getStaff() {
		return staff;
	}
}
