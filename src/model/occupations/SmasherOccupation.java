package model.occupations;

public class SmasherOccupation extends Occupation {
	//private SmasherSkillManager skillManager;
	
	public SmasherOccupation() {
		super();
		setAbilities();
		setOccupationName("Smasher");
	}

	private void setAbilities() {
		//abilityList.add(new OneHanded());
	}
	/*
	public void setSkillManager(SmasherSkillManager skillManager) {
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
