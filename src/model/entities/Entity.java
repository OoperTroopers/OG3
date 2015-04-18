package model.entities;

import model.inventory.Inventory;
import model.equipmentmanagers.*;
import model.occupations.*;
import model.statistics.*;
import model.items.TakeableItem;
import utilities.TileAlgorithm.Direction;
import view.modelview.tile.TileView;
import view.modelview.tileable.TileableView;

import java.util.ArrayList;
import java.util.Observer;

import model.map.Journal;
import model.map.Moveable;
import model.map.MovementCapabilities;
import model.map.Tileable;
import model.map.Tile;
public abstract class Entity implements Tileable, Moveable{
        private Tile myTile;
        private MovementCapabilities myMovement;
        
        private TileableView entityView;
        
        
	private Inventory inventory;
	private EquipmentManager equipmentManager;
	private Occupation occupation;
	private Statistics stats;
	private int direction;
	
	// generic constructor creates Smasher as base class
	public Entity() {
		this.inventory = new Inventory();
		this.stats = new SmasherStatistics();
		this.equipmentManager = new SmasherEquipmentManager(stats.getDerivedStats());
		this.occupation = new SmasherOccupation();
		this.direction = 8;
	}
	
	public Entity(Tile tile, TileableView entityView) {
		this.inventory = new Inventory();
		this.stats = new SmasherStatistics();
		this.equipmentManager = new SmasherEquipmentManager(stats.getDerivedStats());
		this.occupation = new SmasherOccupation();
		this.direction = 8;
		this.myTile = tile;
		this.entityView = entityView;
		this.myTile.addTileable(this);
	}
	
	// constructor for Entity with specific occupation. 
	//needs refactor to account for equipment manager needing derived stats
	public Entity(Occupation o, EquipmentManager em, Statistics s) {
		this.inventory = new Inventory();
		this.equipmentManager = em;
		this.occupation = o;
		this.stats = s;
		this.direction = 8;
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
			respawn();
		}
	}
	
	protected void respawn() {
		stats.loseLife();
		if(stats.getLivesLeft() > 0) {
			//respawn logic
		} else {
			//remove references to self to allow garbage collection
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
	
	public int getCurrentGold() {
		return stats.getCurrentGold();
	}
	
	public void setGold(int gold) {
		stats.setCurrentGold(gold);
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
        	if (myTile.move(this, Direction.NORTH)) {
            	myTile = myTile.getNeighbor(Direction.NORTH);
            }
        }
        public void moveSouth(){
            if (myTile.move(this, Direction.SOUTH)) {
            	myTile = myTile.getNeighbor(Direction.SOUTH);
            }
        }
        public void moveNorthwest(){
        	if (myTile.move(this, Direction.NORTHWEST)) {
            	myTile = myTile.getNeighbor(Direction.NORTHWEST);
            }
        }
        public void moveNortheast(){
        	if (myTile.move(this, Direction.NORTHEAST)) {
            	myTile = myTile.getNeighbor(Direction.NORTHEAST);
            }
        }
        public void moveSoutheast(){
        	if (myTile.move(this, Direction.SOUTHEAST)) {
            	myTile = myTile.getNeighbor(Direction.SOUTHEAST);
            }
        }
        public void moveSouthwest(){
        	if (myTile.move(this, Direction.SOUTHWEST)) {
            	myTile = myTile.getNeighbor(Direction.SOUTHWEST);
            }
        }
        
    	public void sendToView(TileView tileView) {
    		tileView.accept(entityView);
    	}
    	
    	public void removeFromView(TileView tileView) {
    		tileView.remove(entityView);
    	}
}
