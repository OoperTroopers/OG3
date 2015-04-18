package model.entities;

import model.equipmentmanagers.MountEquipmentManager;
import model.occupations.MountOccupation;
import model.statistics.MountStatistics;

public class Mount extends NPC {

	private Avatar av;
	
	public Mount(){
		super(new MountOccupation(), new MountEquipmentManager(), new MountStatistics(), true);
	}
	
	public void Mount(Avatar av){
		this.av = av;
	}
	
	public void UnMount(){
		av = null;
	}
}
