package model.abilities;

import java.util.ArrayList;

import model.abilities.Ability;
import model.statistics.DerivedStatistics;

public class AbilityMenu {
	private ArrayList<Ability> abilityList;
	private DerivedStatistics derivedStats;
	private int assignableAbilityPoints;
	private boolean abilityOpen;
	
	public AbilityMenu(ArrayList<Ability> al, DerivedStatistics ds, int aap) {
		this.abilityList = al;
		this.derivedStats = ds;
		this.assignableAbilityPoints = aap;
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
		if(assignableAbilityPoints > 0) {
			derivedStats.removeAbilityLevel(ability.getAbilityLevel());
			ability.levelSkillUp();
			derivedStats.addAbilityLevel(ability.getAbilityLevel());
			decrementAbilityPoints();
		}
		else {
			//tell view to highlight no points
		}
	}
	
	public void decrementAbilityPoints() {
		--assignableAbilityPoints;
	}
}
