package model.occupations;

import model.abilities.*;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SummonerEquipmentManager;
import model.statistics.Statistics;
import model.statistics.SummonerStatistics;

public class SummonerOccupation extends Occupation {
	public SummonerOccupation() {
		super();
		setAbilities();
		setOccupationName("Summoner");
	}
		
	private void setAbilities() {
		getAbilityList().add(new Bane());
		getAbilityList().add(new Boon());
		getAbilityList().add(new Enchantment());
		getAbilityList().add(new StaffAbility());
	}
	
	public int getBaneLevel() {
		return getAbilityList().get(3).getAbilityLevel();
	}
	public int getBoonLevel() {
		return getAbilityList().get(4).getAbilityLevel();
	}
	public int getEnchantmentLevel() {
		return getAbilityList().get(5).getAbilityLevel();
	}
	public int getStaffAbilityLevel() {
		return getAbilityList().get(6).getAbilityLevel();
	}

	@Override
	public EquipmentManager createEquipmentManager() {
		Statistics stats = this.createStatistics();
		return new SummonerEquipmentManager(stats.getDerivedStats(), this);
	}

	@Override
	public Statistics createStatistics() {
		return new SummonerStatistics();
	}
}
