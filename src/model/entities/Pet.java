package model.entities;

import model.equipmentmanagers.EquipmentManager;
import model.map.Tile;
import model.occupations.Occupation;
import model.statistics.Statistics;
import utilities.TileAlgorithm;
import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.PetBrain;

public class Pet extends NPC {

	private Avatar owner;
	private PetBrain brain = new PetBrain(this);
	
	public Pet(){
		super();
		owner = null;
	}
	
	public Pet(Occupation o, EquipmentManager em, Statistics s, boolean h) {
		super(o, em, s, h);
		owner = null;
	}
	
	public Pet(Occupation o, EquipmentManager em, Statistics s, boolean h, Avatar owner) {
		super(o, em, s, h);
		this.owner = owner;
		this.brain.setDefaultAbilityKeys();
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
	
	public Direction follow(){
		return TileAlgorithm.getBestDirectionToAvatar(getTile(), owner.getTile());
	}
	
	public void move(Direction direction){
		
	}
	
	@Override
	public void update(Tile tile) {
		brain.updateMovements(tile);
	//	ActiveGameViewport.getInstance().setAvatarTile(tile);	
	}
}
