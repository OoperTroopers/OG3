package model.entities;

import java.util.ArrayList;

import model.effects.Effect;
import model.equipmentmanagers.EquipmentManager;
import model.equipmentmanagers.SmasherEquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.occupations.Occupation;
import model.occupations.SmasherOccupation;
import model.statistics.SmasherStatistics;
import model.statistics.Statistics;

public class NPC extends Entity {
	private boolean hostile;
	private ArrayList<Entity> aggroList;
	
	public NPC() {
		setInventory(new Inventory());
		setEquipmentMangaer(new SmasherEquipmentManager());
		setOccupation(new SmasherOccupation());
		setStats(new SmasherStatistics());
		setDirection(8);
		//this.location = new Location();
		this.hostile = true;
		this.aggroList = new ArrayList<Entity>();
	}
	
	// constructor for Entity with specific occupation
	public NPC(Occupation o, EquipmentManager em, Statistics s, boolean h) {
		setInventory(new Inventory());
		setEquipmentMangaer(em);
		setOccupation(o);
		setStats(s);
		setDirection(8);
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
}
