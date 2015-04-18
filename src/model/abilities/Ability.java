package model.abilities;

//import controller.ControllerAvatar;

public abstract class Ability {
	private int abilityLevel;
	private String name;
	
	public Ability() {
		this.abilityLevel = 1;
		this.name = "Ability";
	}
	 /*
    void attachToController(ControllerAvatar controlAvatar);*/

    public abstract void perform();
    
	public void levelSkillUp() {
		++abilityLevel;
	}
	public int getAbilityLevel() {
		return abilityLevel;
	}
	public void setAbilityLevel(int abilityLevel) {
		this.abilityLevel = abilityLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
