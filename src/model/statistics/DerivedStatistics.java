package model.statistics;

public class DerivedStatistics {
	private PrimaryStatistics primaryStats;
	private int offensiveRating;
	private int defensiveRating;
	private int armorRating;
	private int maxHealth;
	private int maxMana;
	
	public DerivedStatistics() {
	}
	
	public DerivedStatistics(PrimaryStatistics primaryStats) {
		this.primaryStats = primaryStats;
		this.maxHealth = 10;
	}

	public void updateAfterLevelUp(PrimaryStatistics primaryStats) {
		//subtract old primary stats calculation
		//add new primary stats calculation
		//so as to not influence the equippable stats boosts
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
