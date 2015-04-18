package model.occupations;

import java.util.ArrayList;
import model.abilities.*;

public abstract class Occupation {
	private ArrayList<Ability> abilityList;
	private String occupationName;
	
	public Occupation() {
		abilityList = new ArrayList<Ability>();
		setAbilities();
		this.occupationName = "Occupation";
	}

	private void setAbilities() {
		//abilityList.add(new BindWounds());
		//abilityList.add(new Bargain());
		//abilityList.add(new Observation());
	}
	
	public void setOccupationName(String name) {
		this.occupationName = name;
	}
	
	public String getOccupationName() {
		return occupationName;
	}
	
	/*
	public void setSkillManager(SkillManager skillManager) {
		this.skillManager = skillManager;
	}
	
	public String getOccupationName() {
		return skillManager;
	}
	
	public void useAbility(Skill skill) {
		//call skill manager->call skill->call use effect
	}
	*/
}
