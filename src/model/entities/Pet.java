package model.entities;

import model.equipmentmanagers.EquipmentManager;
<<<<<<< HEAD
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
	
//	public Direction trackAvatar(){
//		return TileAlgorithm.shortestPath(getTile(), avatar.getTile());
//	}
=======
import model.occupations.Occupation;
import model.statistics.Statistics;

public class Pet extends NPC {
	private Avatar owner;
	
	public Pet(){
		super();
	}
	
	public Pet(Occupation o, EquipmentManager em, Statistics s, boolean h) {
		super(o, em, s, h);
		owner = null;
	}
	
	public Pet(Occupation o, EquipmentManager em, Statistics s, boolean h, Avatar owner) {
		super(o, em, s, h);
		this.owner = owner;
	}
	
	public void setOwner(Avatar owner){
		this.owner = owner;
	}
	
	public void abandoned() {
		owner = null;
	}
	
	public void follow() {
		//move to owner previous tile
	}
>>>>>>> d6730d63b263c9bce57dd5ef9ef634101610b9d8
}
