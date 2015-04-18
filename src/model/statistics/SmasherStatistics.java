package model.statistics;

public class SmasherStatistics extends Statistics {
	//generic Smasher
	public SmasherStatistics() {
		setPrimaryStats(new PrimaryStatistics(10, 7, 5, 5, 3, 2));
		setDerivedStats(new DerivedStatistics(getPrimaryStats()));
		setCurrentGold(0);
		setCurrentHealth(getDerivedStats().getMaxHealth());
		setCurrentMana(getDerivedStats().getMaxMana());
		setCurrentExperience(0);
		setCurrentLevel(1);
	}
	//custom Smasher
	public SmasherStatistics(PrimaryStatistics primaryStats) {
		setPrimaryStats(primaryStats);
		setDerivedStats(new DerivedStatistics(getPrimaryStats()));
		setCurrentGold(0);
		setCurrentHealth(getDerivedStats().getMaxHealth());
		setCurrentMana(getDerivedStats().getMaxMana());
		setCurrentExperience(0);
		setCurrentLevel(1);
	}
	public void levelUp() {
		while(getCurrentExperience() >= (getCurrentLevel() * 10 + 90)) { 
			decreaseExperience(getCurrentLevel() * 10 + 90);
			incrementLevel();
			
			//old stats
			PrimaryStatistics oldStats = new PrimaryStatistics();
			PrimaryStatistics primaryStats = getPrimaryStats();
			oldStats.setAgility(primaryStats.getAgility());
			oldStats.setStrength(primaryStats.getStrength());
			oldStats.setHardiness(primaryStats.getHardiness());
			oldStats.setIntellect(primaryStats.getIntellect());
			primaryStats.increaseStrength(2);
			primaryStats.increaseHardiness(2);
			primaryStats.increaseAgility(1);
			primaryStats.increaseIntellect(1);
		
			getDerivedStats().updateAfterLevelUp(oldStats, primaryStats, getCurrentLevel());
			setCurrentHealth(getDerivedStats().getMaxHealth());
			setCurrentMana(getDerivedStats().getMaxMana());
		}
	}
}
