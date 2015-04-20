package model.statistics;

import view.view.ActiveGameViewport;

public abstract class Statistics {
	private PrimaryStatistics primaryStats;
	private DerivedStatistics derivedStats;
	private int currentGold;
	private int currentHealth;
	private int currentMana;
	private int currentExperience;
	private int currentLevel;
	private int assignableAbilityPoints;
	
	public Statistics() {
		this.primaryStats = new PrimaryStatistics();
		this.derivedStats = new DerivedStatistics(primaryStats);
		this.currentGold = 0;
		this.currentHealth = derivedStats.getMaxHealth();
		this.currentMana = derivedStats.getMaxMana();
		this.currentExperience = 0;
		this.currentLevel = 1;
		this.assignableAbilityPoints = 0;
	}
	
	public abstract void levelUp();
	public void increaseExperience(int experience) {
		currentExperience += experience;
		levelUp();
	}
	public void decreaseExperience(int experience) {
		currentExperience -= experience;
	}
	public void recieveGold(int gold) {
		currentGold += gold;
	}
	public void spendGold(int gold) {
		currentGold -= gold;
	}
	public void incrementLevel() {
		++currentLevel;
	}
	public void increaseAssignableAbilityPoints(int points) {
		assignableAbilityPoints += points;
	}
	
	public int getOffensiveRating() {
		return derivedStats.getOffensiveRating();
	}
	
	public int getDefensiveRating() {
		return derivedStats.getDefensiveRating();
	}
	
	public int getArmorRating() {
		return derivedStats.getArmorRating();
	}
	
	public void heal(int health) {
		currentHealth += health;
		currentHealth = Math.min(currentHealth, derivedStats.getMaxHealth());
		// if (currentHealth <= -1 && primaryStats.getLivesLeft() <= 0) System.exit(0);
	}
	
	public void wound(int damage) {
		currentHealth -= damage;
		// if (currentHealth <= -1  && primaryStats.getLivesLeft() <= 0) System.exit(0);
	}
	
	public void loseLife() {
		primaryStats.loseLife();
		if (currentHealth <= 0 && primaryStats.getLivesLeft() <= 0) System.exit(0);
	}
	public void gainNewLife() {
		primaryStats.gainNewLife();
	}
	public void setCurrentHealthMax(){
		currentHealth = derivedStats.getMaxHealth();
	}
	public void setCurrentManaMax() {
		currentMana = derivedStats.getMaxMana();
	}
	
	public int getLivesLeft() {
		return primaryStats.getLivesLeft();
	}
	
	public PrimaryStatistics getPrimaryStats() {
		return primaryStats;
	}
		
	public void setPrimaryStats(PrimaryStatistics primaryStats) {
		this.primaryStats = primaryStats;
	}
	public DerivedStatistics getDerivedStats() {
		return derivedStats;
	}
	public void setDerivedStats(DerivedStatistics derivedStats) {
		this.derivedStats = derivedStats;
	}
	public int getCurrentGold() {
		return currentGold;
	}
	public void setCurrentGold(int currentGold) {
		this.currentGold = currentGold;
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	public int getCurrentMana() {
		return currentMana;
	}
	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}
	public int getCurrentExperience() {
		return currentExperience;
	}
	public void setCurrentExperience(int currentExperience) {
		this.currentExperience = currentExperience;
	}
	public int getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	public int getAssignableAbilityPoints() {
		return assignableAbilityPoints;
	}
	public void setAssignableAbilityPoints(int assignableAbilityPoints) {
		this.assignableAbilityPoints = assignableAbilityPoints;
	}
	
	public void notifyGameView() {
		ActiveGameViewport.getInstance().updateStats(this);
	}

	public String toString() {
		return "Current Gold: "+currentGold+
				"\nCurrent Health: "+currentHealth+
				"\nCurrent Mana: "+currentMana+
				"\nCurrent Experience: "+currentExperience+
				"\nCurrent Level: "+currentLevel+
				"\nAbility Points: "+assignableAbilityPoints;
	}
}
