package model.occupations;

public class SummonerOccupation extends Occupation {
	//private SummonerSkillManager skillManager;
	private String occupationName;
		
	public SummonerOccupation() {
		//this.skillManager = new SummonerSkillManager();
		this.occupationName = "Summoner";
	}
		
	public void setOccupationName(String name) {
		this.occupationName = name;
	}
		
	public String getOccupationName() {
		return occupationName;
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
