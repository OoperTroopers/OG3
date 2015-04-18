package model.statistics;

public class MountStatistics extends Statistics {
	//generic Mount
	public MountStatistics() {
		setPrimaryStats(new PrimaryStatistics(5, 5, 5, 5, 1, 10));
		setDerivedStats(new DerivedStatistics(getPrimaryStats()));
		setCurrentGold(0);
		setCurrentHealth(getDerivedStats().getMaxHealth());
		setCurrentMana(getDerivedStats().getMaxMana());
		setCurrentExperience(0);
		setCurrentLevel(1);
	}
	//custom Mount
	public MountStatistics(PrimaryStatistics primaryStats) {
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
			primaryStats.increaseAgility(1);
			primaryStats.increaseIntellect(1);
		
			getDerivedStats().updateAfterLevelUp(oldStats, primaryStats, getCurrentLevel());
			setCurrentHealth(getDerivedStats().getMaxHealth());
			setCurrentMana(getDerivedStats().getMaxMana());
		}
	}
}
