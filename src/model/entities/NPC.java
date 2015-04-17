package model.entities;

import java.util.ArrayList;

import model.effects.Effect;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SmasherEquipmentManager;
import model.inventory.Inventory;
import model.map.MovementCapabilities;
import model.map.Tile;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.occupations.Occupation;
import model.statistics.Statistics;

public class NPC extends Entity {
	private boolean hostile;
	private ArrayList<Entity> aggroList;
	
	public NPC() {
		super();
		this.hostile = true;
		this.aggroList = new ArrayList<Entity>();
	}
	
	// constructor for Entity with specific occupation
	public NPC(Occupation o, EquipmentManager em, Statistics s, boolean h) {
		super(o, em, s);
		//this.location = new Location();
		this.hostile = h;
		this.aggroList = new ArrayList<Entity>();
	}
	
	public void dialgue() {
		System.out.println("I am a god. Fear me.");
	}
	
	public void trackAvatar() {
		//do stuff
	}
	
	@Override
	public void receiveDamage(int damage) {
		damage -= getStats().getDefensiveRating();
		damage = Math.max(0, damage);
		getStats().wound(damage);
		if(getStats().getCurrentHealth() <= 0) {
			//die. if lives left respawn as well
		}
		hostile = true;
	}

	@Override
	public void acceptEffect(Effect e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromTile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tile getContainingTile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTraversable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entity clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovementCapabilities getMovementCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canMoveNorth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveNortheast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveNorthwest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveSouth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveSoutheast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveSouthwest() {
		// TODO Auto-generated method stub
		return false;
	}
}
