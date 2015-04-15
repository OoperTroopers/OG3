package model.entities;

import model.inventory.Inventory;
import model.equipmentmanagers.*;
import model.occupations.*;
import model.statistics.*;
import model.items.TakeableItem;
import utilities.TileAlgorithm.Direction;

import java.util.ArrayList;
import model.map.Moveable;
import model.map.Tileable;
import model.map.Tile;

public abstract class Entity implements Tileable, Moveable{
    private Tile myTile;
    
	private Inventory inventory;
	private EquipmentManager equipmentMangaer;
	private Occupation occupation;
	private Statistics stats;
	private int direction;
	//private Location location;
	
	// generic constructor creates Smasher as base class
	public Entity() {
		this.inventory = new Inventory();
		this.equipmentMangaer = new SmasherEquipmentManager();
		this.occupation = new SmasherOccupation();
		this.stats = new SmasherStatistics();
		this.direction = 8;
		//this.location = new Location();
	}
	
	// constructor for Entity with specific occupation
	public Entity(Occupation o, EquipmentManager em, Statistics s) {
		this.inventory = new Inventory();
		this.equipmentMangaer = em;
		this.occupation = o;
		this.stats = s;
		this.direction = 8;
		//this.location = new Location();
	}
	
        /**
         * TODO make this copy the Entity
         * @return a copy of the Entity
         */
        public abstract Entity clone();
       
    public void heal(int amount) {
    	this.stats.heal(amount);
    }
        
	public void receiveDamage(int amount) {
		this.stats.damage(amount);
	}

	public int sendDamage() {
		//send offensive damage to location
		return 0;
	}
	
	public void changeLocation(int x, int y) {
		//modify location
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

	public EquipmentManager getEquipmentMangaer() {
		return equipmentMangaer;
	}

	public void setEquipmentMangaer(EquipmentManager equipmentMangaer) {
		this.equipmentMangaer = equipmentMangaer;
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
            myTile.move(this, Direction.NORTH);
        }
        public void moveSouth(){
            myTile.move(this, Direction.SOUTH);
        }
        public void moveNorthwest(){
            myTile.move(this, Direction.NORTHWEST);
        }
        public void moveNortheast(){
            myTile.move(this, Direction.NORTHEAST);
        }
        public void moveSoutheast(){
            myTile.move(this, Direction.SOUTHEAST);
        }
        public void moveSouthwest(){
            myTile.move(this, Direction.SOUTHWEST);
        }
	
}
