package model.statistics;

public abstract class Statistics {
	private PrimaryStatistics primaryStats;
	private DerivedStatistics derivedStats;
	private int currentGold;
	private int currentHealth;
	private int currentMana;
	private int currentExperience;
	private int currentLevel;
	
	public Statistics() {
		this.primaryStats = new PrimaryStatistics();
		this.derivedStats = new DerivedStatistics(primaryStats);
		this.currentGold = 0;
		this.currentHealth = derivedStats.getMaxHealth();
		this.currentMana = derivedStats.getMaxMana();
		this.currentExperience = 0;
		this.currentLevel = 1;
	}
	
	public abstract void levelUp();
	public void increaseExperience(int experience) {
		currentExperience += experience;
		levelUp();
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
	public void fullRestore() {
		currentHealth = derivedStats.getMaxHealth();
		currentMana = derivedStats.getMaxMana();
	}
	
	public void heal(int amount) {
		int maxHealth = this.derivedStats.getMaxHealth();
		this.currentHealth = Math.min(this.currentHealth + amount, maxHealth);
	}
	
	public void damage(int amount) {
		this.currentHealth = Math.max(0, this.currentHealth - amount);
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
}
