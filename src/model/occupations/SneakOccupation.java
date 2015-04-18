package model.occupations;

import model.abilities.*;

public class SneakOccupation extends Occupation {
	
	public SneakOccupation() {
		super();
		setAbilities();
		setOccupationName("Sneak");
	}
	

	private void setAbilities() {
		getAbilityList().add(new Creep());
		getAbilityList().add(new Pickpocket());
		getAbilityList().add(new TrapAwareness());
		getAbilityList().add(new RangedAbility());
	}
	
	public int getCreepLevel() {
		return getAbilityList().get(3).getAbilityLevel();
	}
	public int getPickpocketLevel() {
		return getAbilityList().get(4).getAbilityLevel();
	}
	public int getTrapAwarenessLevel() {
		return getAbilityList().get(5).getAbilityLevel();
	}
	public int getRangedAbilityLevel() {
		return getAbilityList().get(6).getAbilityLevel();
	}
}
