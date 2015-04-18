package model.statistics;

public class SneakStatistics extends Statistics {
	//generic Sneak
	public SneakStatistics() {
		setPrimaryStats(new PrimaryStatistics(5, 7, 10, 5, 3, 4));
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
		while(getCurrentExperience() >= (getCurrentLevel() * 10 + 90)) { 
			decreaseExperience(getCurrentLevel() * 10 + 90);
			incrementLevel();
			increaseAssignableAbilityPoints(15);

			PrimaryStatistics oldStats = new PrimaryStatistics();
			PrimaryStatistics primaryStats = getPrimaryStats();
			oldStats.setAgility(primaryStats.getAgility());
			oldStats.setStrength(primaryStats.getStrength());
			oldStats.setHardiness(primaryStats.getHardiness());
			oldStats.setIntellect(primaryStats.getIntellect());
			primaryStats.increaseStrength(1);
			primaryStats.increaseHardiness(1);
			primaryStats.increaseAgility(2);
			primaryStats.increaseIntellect(1);
		
			getDerivedStats().updateAfterLevelUp(oldStats, primaryStats, getCurrentLevel());
			setCurrentHealth(getDerivedStats().getMaxHealth());
			setCurrentMana(getDerivedStats().getMaxMana());
		}
	}
}
