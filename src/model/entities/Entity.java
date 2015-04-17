package model.entities;

import model.inventory.Inventory;
import model.equipmentmanagers.*;
import model.occupations.*;
import model.statistics.*;
import model.items.TakeableItem;
import utilities.TileAlgorithm.Direction;
import view.modelview.tileable.TileableView;

import java.util.ArrayList;
import java.util.Observer;

import model.map.Journal;
import model.map.Moveable;
import model.map.MovementCapabilities;
import model.map.Tileable;
import model.map.Tile;
import model.map.Location;

public abstract class Entity implements Tileable, Moveable{
        private Tile myTile;
        private MovementCapabilities myMovement;
        
        private TileableView tileableView;
        
        
	private Inventory inventory;
	private EquipmentManager equipmentManager;
	private Occupation occupation;
	private Statistics stats;
	private int direction;
	private Location location;
	// I don't think entities should know where they are. Discuss?
	// - danny
	
	// generic constructor creates Smasher as base class
	public Entity() {
		this.inventory = new Inventory();
		this.stats = new SmasherStatistics();
		this.equipmentManager = new SmasherEquipmentManager(stats.getDerivedStats());
		this.occupation = new SmasherOccupation();
		this.direction = 8;
		this.location = new Location(0,0,0);
	}
	
	// constructor for Entity with specific occupation. 
	//needs refactor to account for equipment manager needing derived stats
	public Entity(Occupation o, EquipmentManager em, Statistics s) {
		this.inventory = new Inventory();
		this.equipmentManager = em;
		this.occupation = o;
		this.stats = s;
		this.direction = 8;
		this.location = new Location(0,0,0);
	}
	
        /**
         * TODO make this copy the Entity
         * @return a copy of the Entity
         */
        public abstract Entity clone();
       
        
    public void heal(int amount) {
    	this.stats.heal(amount);
    }
        
	public void receiveDamage(int damage) {
		damage -= stats.getDefensiveRating();
		damage = Math.max(0, damage);
		stats.wound(damage);
		if(stats.getCurrentHealth() <= 0) {
			//die. if lives left respawn as well
		}
	}

	public int sendDamage() {
		int damage = stats.getOffensiveRating();
		return damage;
	}
	
	/*public void changeLocation(int q, int r) {
		location.setQ(q);
		location.setR(r);
	}*/
	// right now, setQ and setR are unimplemented
	public void changeLocation(int x, int y, int z) {
		location = new Location(x, y, z);
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void addItemToInventory(TakeableItem item) {
		inventory.addToInventory(item);
	}
	
	public void dropItem(TakeableItem item) {
		inventory.dropFromInventory(item);
	}
	
	public void removeItem(TakeableItem item) {
		inventory.removeFromInventory(item);
	}
	
	public ArrayList<TakeableItem> getAllItems() {
		return inventory.getInventory();
	}

	public TakeableItem getItemFromInvnetory(TakeableItem item) {
		if(inventory.itemInInventory(item)) {
			return item;
		} else {
			return null;
		}
	}

	public void dialogue() {
		//do dialogue
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public EquipmentManager getEquipmentManager() {
		return equipmentManager;
	}

	public void setEquipmentManager(EquipmentManager equipmentManager) {
		this.equipmentManager = equipmentManager;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public Statistics getStats() {
		return stats;
	}

	public void setStats(Statistics stats) {
		this.stats = stats;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
        /*
        * Map Interaction
        */
        
        
        /* These are the move commands for entity. Logic for whether or not these 
            get called should be done before you call these. i.e. the controller should
            know whether or not it's legal to move the Entity.
        */
        public void moveNorth(){
            myTile.moveNorth(this);
        }
        public void moveSouth(){
            myTile.moveSouth(this);
        }
        public void moveNorthwest(){
            myTile.moveNorthwest(this);
        }
        public void moveNortheast(){
            myTile.moveNorthwest(this);
        }
        public void moveSoutheast(){
            myTile.moveSoutheast(this);
        }
        public void moveSouthwest(){
            myTile.moveSouthwest(this);
        }
 }
