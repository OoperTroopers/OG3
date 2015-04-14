package model.statistics;

public class SummonerStatistics extends Statistics {
	//generic Summoner
	public SummonerStatistics() {
		setPrimaryStats(new PrimaryStatistics(5, 5, 5, 10, 3));
		setDerivedStats(new DerivedStatistics(getPrimaryStats()));
		setCurrentGold(0);
		setCurrentHealth(getDerivedStats().getMaxHealth());
		setCurrentMana(getDerivedStats().getMaxMana());
		setCurrentExperience(0);
		setCurrentLevel(1);
	}
	//custom Summoner
	public SummonerStatistics(PrimaryStatistics primaryStats) {
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
			if((getCurrentLevel() % 2) == 0) {
				primaryStats.setHardiness(primaryStats.getHardiness() + 1);
			}
			primaryStats.setAgility(primaryStats.getAgility() + 1);
			primaryStats.setIntellect(primaryStats.getIntellect() + 2);
		
			getDerivedStats().updateAfterLevelUp(primaryStats);
			setCurrentHealth(getDerivedStats().getMaxHealth());
			setCurrentMana(getDerivedStats().getMaxMana());
		}
	}
}
