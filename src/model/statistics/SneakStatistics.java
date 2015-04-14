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
			setCurrentExperience(getCurrentExperience() - (getCurrentLevel() * 10 + 90));
			incrementLevel();
			
			PrimaryStatistics primaryStats = getPrimaryStats();
			primaryStats.setStrength(primaryStats.getStrength() + 1);
			primaryStats.setHardiness(primaryStats.getHardiness() + 1);
			primaryStats.setAgility(primaryStats.getAgility() + 2);
			primaryStats.setIntellect(primaryStats.getIntellect() + 1);
		
			getDerivedStats().updateAfterLevelUp(primaryStats);
			setCurrentHealth(getDerivedStats().getMaxHealth());
			setCurrentMana(getDerivedStats().getMaxMana());
		}
	}
}
