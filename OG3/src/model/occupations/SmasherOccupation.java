package model.occupations;

import model.abilities.*;

public class SmasherOccupation extends Occupation {
	//private SmasherSkillManager skillManager;
	
	public SmasherOccupation() {
		super();
		setAbilities();
		setOccupationName("Smasher");
	}

	private void setAbilities() {
		getAbilityList().add(new OneHandedWeaponAbility());
		getAbilityList().add(new TwoHandedWeaponAbility());
		getAbilityList().add(new BrawlAbility());
	}
	
	public int getOneHandedAbilityLevel() {
		return getAbilityList().get(3).getAbilityLevel();
	}
	public int getTwoHandedAbilityLevel() {
		return getAbilityList().get(4).getAbilityLevel();
	}
	public int getBrawlAbilityLevel() {
		return getAbilityList().get(5).getAbilityLevel();
	}
}
