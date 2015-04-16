package model.statistics;

public class SneakStatistics extends Statistics {
	//generic Sneak
	public SneakStatistics() {
		setPrimaryStats(new PrimaryStatistics(5, 7, 10, 5, 3));
		setDerivedStats(new DerivedStatistics(getPrimaryStats()));
		setCurrentGold(0);
		setCurrentHealth(getDerivedStats().getMaxHealth());
		setCurrentMana(getDerivedStats().getMaxMana());
		setCurrentExperience(0);
		setCurrentLevel(1);
	}
	//custom Sneak
	public SneakStatistics(PrimaryStatistics primaryStats) {
		setPrimaryStats(primaryStats);
		setDerivedStats(new DerivedStatistics(getPrimaryStats()));
		setCurrentGold(0);
		setCurrentHealth(getDerivedStats().getMaxHealth());
		setCurrentMana(getDerivedStats().getMaxMana());
		setCurrentExperience(0);
		setCurrentLevel(1);
	}
	
	public void levelUp() {
		while(getCurrentExperience() > (getCurrentLevel() * 10 + 90)) { 
			decreaseExperience(getCurrentLevel() * 10 + 90);
			incrementLevel();
			
			PrimaryStatistics primaryStats = getPrimaryStats();
			primaryStats.increaseStrength(1);
			primaryStats.increaseHardiness(1);
			primaryStats.increaseAgility(2);
			primaryStats.increaseIntellect(1);
		
			getDerivedStats().updateAfterLevelUp(primaryStats, getCurrentLevel());
			setCurrentHealth(getDerivedStats().getMaxHealth());
			setCurrentMana(getDerivedStats().getMaxMana());
		}
	}
}
