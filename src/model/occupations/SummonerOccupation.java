package model.occupations;

public class SummonerOccupation extends Occupation {
	public SummonerOccupation() {
		super();
		setAbilities();
		setOccupationName("Summoner");
	}
		
	private void setAbilities() {
		//abilityList.add(new BindWounds());
		//abilityList.add(new Bargain());
		//abilityList.add(new Observation());
	}
	/*
	public void setSkillManager(SummonerSkillManager skillManager) {
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
