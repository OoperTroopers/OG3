package model.abilities;

//import controller.ControllerAvatar;
import model.statistics.*;

public abstract class Ability {
	private Statistics avatarStats;
	private int skillLevel;
	private String name;
	
	public Ability() {
		this.avatarStats = null;
		this.skillLevel = 1;
		this.name = "Ability";
	}
	
	public Ability(Statistics avatarStats, int skillLevel, String name) {
		this.avatarStats = avatarStats;
		this.skillLevel = skillLevel;
		this.name = name;
	}
	
	 /*
    void attachToController(ControllerAvatar controlAvatar);*/

    public abstract void perform();
	public void levelSkillUp() {
		++skillLevel;
	}
	public Statistics getAvatarStats() {
		return avatarStats;
	}
	public void setAvatarStats(Statistics avatarStats) {
		this.avatarStats = avatarStats;
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
