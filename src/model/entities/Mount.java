package model.entities;

import controller.ControllerAvatar;
import model.equipmentmanagers.MountEquipmentManager;
import model.occupations.MountOccupation;
import model.statistics.MountStatistics;

public class Mount extends NPC {

	private Avatar avatar;
	private ControllerAvatar controller;
	
	public Mount(){
		super(new MountOccupation(), new MountEquipmentManager(), new MountStatistics(), true);
		this.avatar = null;
		this.controller = null;
	}
	
	public void mount(Avatar avatar){
		this.avatar = avatar;
		this.controller = avatar.getControlAvatar();
	}
	
	public void unmount(){
		avatar = null;
		//set controller to npc controller
		controller =  null;
	}
}
