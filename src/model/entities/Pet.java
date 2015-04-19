package model.entities;

import view.modelview.tileable.entities.PetView;
import model.equipmentmanagers.EquipmentManager;

import model.occupations.Occupation;
import model.statistics.Statistics;

public class Pet extends NPC {
	private Avatar owner;
	
	public Pet(){
		super(new PetView());
		owner = null;
	}
	
	public Pet(Occupation o, EquipmentManager em, Statistics s, boolean h) {
		super(o, em, s, h);
		owner = null;
	}
	
	public Pet(Occupation o, EquipmentManager em, Statistics s, boolean h, Avatar owner) {
		super(o, em, s, h);
		this.owner = owner;
	}
	
	public Avatar getOwner() {
		return owner;
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
	
//	public Direction trackAvatar(){
//		return TileAlgorithm.shortestPath(getTile(), avatar.getTile());
//	}
}
