package model.occupations;

public class SmasherOccupation extends Occupation {
	//private SmasherSkillManager skillManager;
	private String occupationName;
	
	public SmasherOccupation() {
		//this.skillManager = new SmasherSkillManager();
		this.occupationName = "Smasher";
	}
	
	public void setOccupationName(String name) {
		this.occupationName = name;
	}
	
	public String getOccupationName() {
		return occupationName;
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
