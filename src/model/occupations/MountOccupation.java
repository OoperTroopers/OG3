package model.occupations;

public class MountOccupation extends Occupation {
	//private MountSkillManager skillManager;
	private String occupationName;
	
	public MountOccupation() {
		//this.skillManager = new MountSkillManager();
		this.occupationName = "Mount";
	}
	
	public void setOccupationName(String name) {
		this.occupationName = name;
	}
	
	public String getOccupationName() {
		return occupationName;
	}
	/*
	public void setSkillManager(MountSkillManager skillManager) {
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
