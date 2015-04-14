package model.statistics;

public class SmasherStatistics extends Statistics {
	//generic Smasher
	public SmasherStatistics() {
		setPrimaryStats(new PrimaryStatistics(10, 7, 5, 5, 3));
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
		while(getCurrentExperience() > (getCurrentLevel() * 10 + 90)) { 
			setCurrentExperience(getCurrentExperience() - (getCurrentLevel() * 10 + 90));
			incrementLevel();
			
			PrimaryStatistics primaryStats = getPrimaryStats();
			primaryStats.setStrength(primaryStats.getStrength() + 2);
			primaryStats.setHardiness(primaryStats.getHardiness() + 2);
			primaryStats.setAgility(primaryStats.getAgility() + 1);
			primaryStats.setIntellect(primaryStats.getIntellect() + 1);
		
			getDerivedStats().updateAfterLevelUp(primaryStats);
			setCurrentHealth(getDerivedStats().getMaxHealth());
			setCurrentMana(getDerivedStats().getMaxMana());
		}
	}
}
