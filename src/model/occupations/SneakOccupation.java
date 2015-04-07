package model.occupations;

public class SneakOccupation extends Occupation {
	//private SneakSkillManager skillManager;
	private String occupationName;
	
	public SneakOccupation() {
		//this.skillManager = new SneakSkillManager();
		this.occupationName = "Sneak";
	}
	
	public void setOccupationName(String name) {
		this.occupationName = name;
	}
	
	public String getOccupationName() {
		return occupationName;
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
