package model.entities;

import model.equipmentmanagers.MountEquipmentManager;
import model.occupations.MountOccupation;
import model.statistics.MountStatistics;

public class Mount extends NPC {

	private Avatar avatar;
	
	public Mount(){
		super(new MountOccupation(), new MountEquipmentManager(), new MountStatistics(), true);
	}
	
	public void mount(Avatar avatar){
		this.avatar = avatar;
	}
	
	public void unmount(){
		avatar = null;
	}
}
