package model.statistics;

import view.view.ActiveGameViewport;

public class DerivedStatistics {
	private int offensiveRating;
	private int defensiveRating;
	private int armorRating;
	private int maxHealth;
	private int maxMana;
	
	public DerivedStatistics() {
		offensiveRating = 10;
		defensiveRating = 10;
		armorRating = 10;
		maxHealth = 10;
		maxMana = 10;
	}
	
	public DerivedStatistics(PrimaryStatistics primaryStats) {
		offensiveRating = primaryStats.getStrength() + 2;
		defensiveRating = primaryStats.getAgility() + 2;
		armorRating = primaryStats.getHardiness() + 2;
		maxHealth = primaryStats.getHardiness() + 5;
		maxMana = primaryStats.getIntellect()+ 5;
	}

	public void updateAfterLevelUp(PrimaryStatistics oldStats, PrimaryStatistics primaryStats, int level) {
		offensiveRating -= oldStats.getStrength() + 2 * (level - 1);
		defensiveRating -= oldStats.getAgility() + 2 * (level - 1);
		armorRating -= oldStats.getHardiness() + 2 * (level - 1);
		maxHealth -= oldStats.getHardiness() + 5 * (level - 1);
		maxMana -= oldStats.getIntellect() + 5 * (level - 1);
		
		offensiveRating += primaryStats.getStrength() + 2 * level;
		defensiveRating +=  primaryStats.getAgility() + 2 * level;
		armorRating += primaryStats.getHardiness() + 2 * level;
		maxHealth += primaryStats.getHardiness() + 5 * level;
		maxMana += primaryStats.getIntellect() + 5 * level;
		notifyGameView();
	}
	
	public void addEquippable(EquippableStatistics equippableStats){
		this.offensiveRating += equippableStats.getDamageValue();
		this.armorRating += equippableStats.getArmorValue();
		notifyGameView();
	}
	
	public void removeEquippable(EquippableStatistics equippableStats){
		this.offensiveRating -= equippableStats.getDamageValue();
		this.armorRating -= equippableStats.getArmorValue();
		notifyGameView();
	}
	
	public void addAbilityLevel(int abilityLevel) {
		offensiveRating += abilityLevel;
		notifyGameView();
	}
	
	public void removeAbilityLevel(int abilityLevel) {
		offensiveRating -= abilityLevel;
		notifyGameView();
	}
	
	public int getOffensiveRating() {
		return offensiveRating;
	}

	public void setOffensiveRating(int offensiveRating) {
		this.offensiveRating = offensiveRating;
		notifyGameView();
	}

	public int getDefensiveRating() {
		return defensiveRating;
	}

	public void setDefensiveRating(int defensiveRating) {
		this.defensiveRating = defensiveRating;
		notifyGameView();
	}

	public int getArmorRating() {
		return armorRating;
	}

	public void setArmorRating(int armorRating) {
		this.armorRating = armorRating;
		notifyGameView();
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
		notifyGameView();
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
		notifyGameView();
	}
	
	public String toString() {
		return 	"Offensive Rating: "+offensiveRating+
				"\nDefensiveRating: "+defensiveRating+
				"\nArmor Rating: "+ armorRating+
				"\nMax Health: "+maxHealth+
				"\nMax Mana: "+maxMana;
	}
	
	public void notifyGameView() {
		ActiveGameViewport.getInstance().updateDeriveds(this);
	}
}
