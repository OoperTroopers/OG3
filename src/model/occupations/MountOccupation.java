package model.occupations;

import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.MountEquipmentManager;
import model.statistics.MountStatistics;
import model.statistics.Statistics;

public class MountOccupation extends Occupation {
	
	public MountOccupation() {
		super();
		setOccupationName("Mount");
	}

	@Override
	public EquipmentManager createEquipmentManager() {
		return new MountEquipmentManager();
	}

	@Override
	public Statistics createStatistics() {
		return new MountStatistics();
	}
}
