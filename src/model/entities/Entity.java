package model.entities;

import model.inventory.Inventory;
import model.abilities.ExplicitAbility;
import model.abilities.ImplicitAbility;
import model.equipmentmanagers.*;
import model.occupations.*;
import model.statistics.*;
import model.items.TakeableItem;
import utilities.TileAlgorithm.Direction;
import view.modelview.tile.TileView;
import view.modelview.tileable.TileableView;

import java.util.ArrayList;
import model.map.Moveable;
import model.map.MovementCapabilities;
import model.map.Tileable;
import model.map.Tile;
import view.view.ActiveGameViewport;
public abstract class Entity implements Tileable, Moveable {
	
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
		this.occupation = new SmasherOccupation();
		this.equipmentManager = new SmasherEquipmentManager(stats.getDerivedStats(), occupation);
		this.direction = 8;
	}
	
	public Entity(TileableView entityView) {
		this.inventory = new Inventory();
		this.stats = new SmasherStatistics();
		this.occupation = new SmasherOccupation();
		this.entityView = entityView;
		this.equipmentManager = new SmasherEquipmentManager(stats.getDerivedStats(), occupation);
		this.direction = 8;
	}

	public Entity(Tile tile, TileableView entityView) {
		this.inventory = new Inventory();
		this.stats = new SmasherStatistics();
		this.occupation = new SmasherOccupation();
		this.equipmentManager = new SmasherEquipmentManager(stats.getDerivedStats(), occupation);
		this.direction = 8;
		this.myTile = tile;
		this.entityView = entityView;
		this.myTile.addTileable(this);
	}
	
	public Entity(Occupation o, EquipmentManager em, Statistics s) {
		this.inventory = new Inventory();
		this.equipmentManager = em;
		this.occupation = o;
		this.stats = s;
		this.direction = 8;
	}

	// constructor for Entity with specific occupation. 
	//needs refactor to account for equipment manager needing derived stats
	public Entity(Occupation o, EquipmentManager em, Statistics s, Tile tile, TileableView entityView) {
		this.inventory = new Inventory();
		this.equipmentManager = em;
		this.occupation = o;
		this.stats = s;
		this.direction = 8;
		this.myTile = tile;
		this.entityView = entityView;
		this.myTile.addTileable(this);
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
			stats.setCurrentHealthMax();
			stats.setCurrentManaMax();
		} else {
			myTile.removeTileable(this);
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
	public int getBargainingAbilityLevel() {
		return occupation.getBargainingAbilityLevel();
	}
	public int getBindWoundsAbilityLevel() {
		return occupation.getBindWoundsAbilityLevel();
	}
	public int getObservationAbilityLevel() {
		return occupation.getObservationAbilityLevel();
	}
	public void increaseExperience(int experience) {
		stats.increaseExperience(experience);
	}
	public int getCurrentLevel() {
		return stats.getCurrentLevel();
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
	protected void move(Direction direction) {
		myTile.removeTileable(this);
		myTile = myTile.getNeighbor(direction);
		update(myTile);
		
		myTile.addTileable(this);
		onMove();
	}
	
	public abstract void onMove();
	
	public abstract void update(Tile tile);


	public void moveNorth(){
		move(Direction.NORTH);
	}

	public void moveSouth(){
		move(Direction.SOUTH);
	}

	public void moveNorthwest(){
		move(Direction.NORTHWEST);
	}

	public void moveNortheast(){
		move(Direction.NORTHEAST);
	}

	public void moveSoutheast(){
		move(Direction.SOUTHEAST);
	}

	public void moveSouthwest(){
		move(Direction.SOUTHWEST);
	}

	public void sendToView(TileView tileView) {
		tileView.accept(entityView);
	}

	public void removeFromView(TileView tileView) {
		tileView.remove(entityView);
	}
	
	public void addAbility(ImplicitAbility ability){
		occupation.addAbility(ability);
	}
	
	public void addAbility(ExplicitAbility ability) {
		occupation.addAbility(ability);
	}
	
	public Tile getTile() {
		return myTile;
	}
	
	public void setTile(Tile tile) {
		this.myTile = tile;
	}

	public void removeFromTile() {
		this.myTile.removeTileable(this);		
	}
	
	public abstract void interact(Tileable tileable);	
	public abstract void acceptAvatar(Avatar avatar);
}
