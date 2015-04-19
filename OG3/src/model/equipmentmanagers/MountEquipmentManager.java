package model.equipmentmanagers;

import model.items.Arms;
import model.items.Chest;
import model.items.Helmet;
import model.items.Legs;
import model.items.Saddle;
import model.occupations.Occupation;
import model.statistics.DerivedStatistics;

public class MountEquipmentManager extends EquipmentManager {
	private Saddle saddle;

	public MountEquipmentManager() {
		super();
		this.saddle = null;
	}
	
	public MountEquipmentManager(DerivedStatistics derivedStats, Occupation occupation) {
		super(derivedStats, occupation);
		this.saddle = null;
	}
	
	public MountEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs, Saddle saddle,
			DerivedStatistics derivedStats, Occupation occupation) {
		super(helmet, chest, arms, legs, derivedStats, occupation);
		this.saddle = saddle;
	}
	
	public void equipSaddle(Saddle saddle) {
		this.saddle = saddle;
		getDerivedStats().addEquippable(saddle.getEquipStats());
	}
	
	public void unequipSaddle() {
		if(saddle != null) {
			getDerivedStats().removeEquippable(saddle.getEquipStats());
		}
		saddle = null;
	}
	
	public Saddle getSaddle() {
		return saddle;
	}
}
