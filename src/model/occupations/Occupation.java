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
		abilityList.add(new Bargain());
		//abilityList.add(new BindWounds());
		//abilityList.add(new Observation());
	}
	
	public void setOccupationName(String name) {
		this.occupationName = name;
	}
	
	public String getOccupationName() {
		return occupationName;
	}
	
	public int getBargainingSkillLevel() {
		return abilityList.get(0).getSkillLevel();
	}
	public int getBindWoundsSkillLevel() {
		return abilityList.get(1).getSkillLevel();
	}
	public int getObservationSkillLevel() {
		return abilityList.get(2).getSkillLevel();
	}
}
