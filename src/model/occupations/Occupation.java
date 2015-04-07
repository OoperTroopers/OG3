package model.occupations;

public abstract class Occupation {
	//private SkillManager skillManager;
	private String occupationName;
	
	public Occupation() {
		//this.skillManager = new SkillManager();
		this.occupationName = "Occupation";
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
