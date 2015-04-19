package model.entities;

import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SmasherEquipmentManager;
import model.occupations.Occupation;
import model.occupations.SmasherOccupation;
import model.statistics.SmasherStatistics;
import model.statistics.Statistics;

public class Pet extends NPC {
	
	private Avatar avatar;
	
	Pet(){
		super(new SmasherOccupation(), new SmasherEquipmentManager(), new SmasherStatistics(), true );
	}
	
	Pet(Occupation o, EquipmentManager em, Statistics s){
		super(o,em,s,true);
	}
	
	Pet(Occupation o, EquipmentManager em, Statistics s, Avatar av){
		super(o,em,s,true);
		this.avatar = av;
	}
	
	public void AddAvatar(Avatar avatar){
		this.avatar = avatar;
	}
}
