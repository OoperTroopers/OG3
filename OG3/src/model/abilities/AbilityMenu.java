package model.abilities;

import java.util.ArrayList;

import model.abilities.Ability;
import model.statistics.DerivedStatistics;
import model.equipmentmanagers.EquipmentManager;

public class AbilityMenu {
	private ArrayList<Ability> abilityList;
	private DerivedStatistics derivedStats;
	private int assignableAbilityPoints;
	private EquipmentManager equipmentManager;
	private boolean abilityOpen;
	
	public AbilityMenu(ArrayList<Ability> al, DerivedStatistics ds, int aap, EquipmentManager em) {
		this.abilityList = al;
		this.derivedStats = ds;
		this.assignableAbilityPoints = aap;
		this.equipmentManager =em;
		abilityOpen = true;
	}
	
	public int openAbilityMenu() {
		while(isOpenAbility()) {
			//do ability menu stuff in here
			abilityOpen = false;
		}
		return assignableAbilityPoints;
	}

	private boolean isOpenAbility() {
		return abilityOpen;
	}
	
	public void closeAbility() {
		abilityOpen = false;
	}
	
	public void assignAbilityPoint(Ability ability) {
		if(assignableAbilityPoints > 0 && ability.getName().equals(equipmentManager.getCurrentSkill())) {
			derivedStats.removeAbilityLevel(ability.getAbilityLevel());
			ability.levelSkillUp();
			derivedStats.addAbilityLevel(ability.getAbilityLevel());
			decrementAbilityPoints();
		}else if(assignableAbilityPoints > 0) {
			ability.levelSkillUp();
			decrementAbilityPoints();
		}else {
			//tell view to highlight no points
		}
	}
	
	public void decrementAbilityPoints() {
		--assignableAbilityPoints;
	}
}
