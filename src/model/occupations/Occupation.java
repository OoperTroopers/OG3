package model.occupations;

import java.util.ArrayList;
import model.abilities.*;
import model.equipmentmanagers.EquipmentManager;
import model.statistics.Statistics;

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
		abilityList.add(new BindWounds());
		abilityList.add(new Observation());
	}
	
	public void setOccupationName(String name) {
		this.occupationName = name;
	}
	
	public String getOccupationName() {
		return occupationName;
	}
	
	public ArrayList<Ability> getAbilityList() {
		return abilityList;
	}
	
	public int getBargainingAbilityLevel() {
		return abilityList.get(0).getAbilityLevel();
	}
	public int getBindWoundsAbilityLevel() {
		return abilityList.get(1).getAbilityLevel();
	}
	public int getObservationAbilityLevel() {
		return abilityList.get(2).getAbilityLevel();
	}
	
	public void addAbility(Ability ability) {
		this.abilityList.add(ability);
	}

	public abstract EquipmentManager createEquipmentManager();
	public abstract Statistics createStatistics();

	public void removeAbility(Ability ability){
		this.abilityList.remove(ability);
	}
}
