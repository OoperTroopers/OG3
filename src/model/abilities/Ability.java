package model.abilities;

//import controller.ControllerAvatar;

public abstract class Ability {
	private int skillLevel;
	private String name;
	
	public Ability() {
		this.skillLevel = 1;
		this.name = "Ability";
	}
	 /*
    void attachToController(ControllerAvatar controlAvatar);*/

    public abstract void perform();
	public void levelSkillUp() {
		++skillLevel;
	}
	public int getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
