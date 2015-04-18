package model.occupations;

public class SneakOccupation extends Occupation {
	
	public SneakOccupation() {
		super();
		setAbilities();
		setOccupationName("Sneak");
	}
	

	private void setAbilities() {
		//abilityList.add(new BindWounds());
		//abilityList.add(new Bargain());
		//abilityList.add(new Observation());
	}
	/*
	public void setSkillManager(SneakSkillManager skillManager) {
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
