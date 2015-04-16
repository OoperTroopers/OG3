package model.statistics;

public class DerivedStatistics {
	private PrimaryStatistics primaryStats;
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
		this.primaryStats = primaryStats;
		offensiveRating = primaryStats.getStrength() + 2;
		defensiveRating = primaryStats.getAgility() + 2;
		armorRating = primaryStats.getHardiness() + 2;
		maxHealth = primaryStats.getHardiness() + 5;
		maxMana = primaryStats.getIntellect() + 5;
	}

	public void updateAfterLevelUp(PrimaryStatistics primaryStats, int level) {
		offensiveRating -= this.primaryStats.getStrength() + 2 * level;
		defensiveRating -= this.primaryStats.getAgility() + 2 * level;
		armorRating -= this.primaryStats.getHardiness() + 2 * level;
		maxHealth -= this.primaryStats.getHardiness() + 5 * level;
		maxMana -= this.primaryStats.getIntellect() + 5 * level;
		
		offensiveRating += primaryStats.getStrength() + 2 * level;
		defensiveRating += primaryStats.getAgility() + 2 * level;
		armorRating += primaryStats.getHardiness() + 2 * level;
		maxHealth += primaryStats.getHardiness() + 5 * level;
		maxMana += primaryStats.getIntellect() + 5 * level;
		
		this.primaryStats = primaryStats;
	}
	
	public void addEquippable(EquippableStatistics equippableStats){
		this.offensiveRating += equippableStats.getDamageValue();
		this.armorRating += equippableStats.getArmorValue();
	}
	
	public void removeEquippable(EquippableStatistics equippableStats){
		this.offensiveRating -= equippableStats.getDamageValue();
		this.armorRating -= equippableStats.getArmorValue();
	}
	
	public int getOffensiveRating() {
		return offensiveRating;
	}

	public void setOffensiveRating(int offensiveRating) {
		this.offensiveRating = offensiveRating;
	}

	public int getDefensiveRating() {
		return defensiveRating;
	}

	public void setDefensiveRating(int defensiveRating) {
		this.defensiveRating = defensiveRating;
	}

	public int getArmorRating() {
		return armorRating;
	}

	public void setArmorRating(int armorRating) {
		this.armorRating = armorRating;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}
}
