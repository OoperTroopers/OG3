package model.entities;

import model.equipmentmanagers.MountEquipmentManager;
import model.map.Tile;
import model.occupations.MountOccupation;
import model.occupations.Occupation;
import model.statistics.MountStatistics;

public class Mount extends NPC {

	private Avatar avatar;
	
	public Mount(Tile tile){
		super(new MountOccupation(), new MountEquipmentManager(), new MountStatistics(), true, tile);
	}
	
	public void mount(Avatar avatar){
		this.avatar = avatar;
	}
	
	public void unmount(){
		avatar = null;
	}
}
