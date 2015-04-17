/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import java.util.*;

import model.effects.Effect;
import model.entities.Entity;
import utilities.TileAlgorithm;
import utilities.TileAlgorithm.Direction;

/**
 * Tile represents the smallest discrete location an object can 
 * have in our game. Each tile has a reference to all of the tiles
 * near it. 
 * @author Jason Owens, Cormac McCarthy
 */
public class Tile {
    
    private Location location;
    private Terrain terrain;
    	// jason, shouldn't this be inside of tileables?
    	// - danny
    
    private HashMap<Direction, Tile> neighbors;
    private ArrayList<Tileable> tileables;
   
    LinkedList<Entity> observers;
    
    public Tile() {
    	this.location = new Location(-200, -200, -200);
    	this.neighbors = new HashMap<Direction, Tile>();
    	this.terrain = new GrassTerrain();
    	tileables = new ArrayList<Tileable>();
    }
    
    public Tile(int x, int y, int z) {
    	this.neighbors = new HashMap<Direction, Tile>();
    	this.terrain = new GrassTerrain();
    	this.setLocation(x, y, z);
    	tileables = new ArrayList<Tileable>();
    }
    
    public Tile(int x, int y, int z, Terrain terrain) {
    	this.neighbors = new HashMap<Direction, Tile>();
    	this.terrain = terrain;
    	this.setLocation(x, y, z);
    	tileables = new ArrayList<Tileable>();
    }
    
    public void affectAllTileables(Effect e){
        for(Tileable t: tileables){
            t.acceptEffect(e);
        }
    }
    
    /**
     * TODO
     * Should this be moved to MemTile?
     * @return MemTile version of this Tile
     * @author Jason Owens
     */
    public MemTile getMemTile(){
        
        List<Tileable> copyOfList = cloneTileables();
        Terrain tCopy = getTerrainClone();
        Location lCopy = getLocationClone();
        
        return new MemTile(this);
        // return new MemTile(this, location, tCopy, copyOfList);
        // return null;//new MemTile(this, location, tCopy, copyOfList);
    }
    
    private ArrayList<Tileable> cloneTileables(){
        ArrayList<Tileable> copyOfList = new ArrayList<>();
        for(Tileable t: tileables){
            copyOfList.add(t.clone());
        }
        return copyOfList;
    }
    
    public void removeTileable(Tileable t){
        tileables.remove(t);
    }
    
    /**
     * Adds a Tileable to the tile
     * @param t the tileable to be added
     */   
    public void addTileable(Tileable t){
    	// should add the location too
        tileables.add(t);
        t.sendViewThisLocation(location);
    }    
    
    /**
     * Add/set a neighboring Tile in a given Direction.
     * @param tile      the Tile that we want to add as a neighbor
     * @param direction the Direction that the neighboring Tile is located
     */
    public void addNeighbor(Tile tile, Direction direction) {
    	this.neighbors.put(direction, tile);
    }
    
    /**
     * Get the neighboring Tile in the specified Direction.
     * @param  direction the Direction of the neighbor that we want
     * @return the Tile that is in the specified Direction from this Tile 
     */
    public Tile getNeighbor(Direction direction) {
    	return this.neighbors.get(direction);
    }    
    
    /*
    * Returning clones here so as to not expose internals
    */      
    public Location getLocationClone() {
        return this.location.clone();
    }
    
    public Terrain getTerrainClone() {
        return this.terrain.clone();
    }
    
    public ArrayList<Tileable> getTileablesClone(){
        return cloneTileables();        
    }
    
    
    /**
     * 
     * @author Jason Owens
     */
    public void addOvserver(Entity e){
        observers.add(e);
    }
    
    
    /**
     * notifies all of the Entities that can see this Tile. Use this method whenever
     * something visible about the tile changes.
     * @author Jason Owens
     */
    public void notifyObservers(){        
        for(Entity e: observers){
            // e.notify(this);	
        	
        	// this throws an error
        }
    }
    
    /**
     * Moves an Entity in a specific Direction.
     * @param entity    the Entity that we want to move
     * @param direction the Direction we want to move the Entity
     */
    public void move(Entity entity, Direction direction) {
    	Tile neighborTile = this.neighbors.get(direction);
    	if (neighborTile == null) return;
    	this.removeTileable(entity);
    	neighborTile.addTileable(entity);
    }    
    
    /**
     * Sets the Location of a Tile.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     */
    public void setLocation(int x, int y, int z) {
    	this.location = new Location(x, y, z);
    	terrain.setLocation(this.location);
    }
    
    public void setTerrain(Terrain terrain) {
    	this.terrain = terrain;
    }
    
    /**
     * Return the x-coordinate of the Tile, which is received from the Location.
     * @return the x-coordinate of the Tile
     */
    public int getX() {
    	return this.location.getX();
    }
    
    /**
     * Return the y-coordinate of the Tile, which is received from the Location.
     * @return the y-coordinate of the Tile
     */
    public int getY() {
    	return this.location.getY();
    }
    
    /**
     * Return the z-coordinate of the Tile, which is received from the Location.
     * @return the z-coordinate of the Tile
     */
    public int getZ() {
    	return this.location.getZ();
    }
    
    /**
     * This method is used in graph traversal to determine if a Tile has been visited.
     * @author Cormac McCarthy
     */
    public boolean equals(Object o) {
    	Tile t = (Tile) o;
    	if (this.hashCode() != t.hashCode()) return false;
    	return true;
    }
    
    /**
     * This method is used in graph traversal to determine if a Tile has been visited.
     * @author Cormac McCarthy
     */
    public int hashCode() {
    	return this.location.hashCode();
    }
    
    /**
     * Overridden toString method that prints out Tile's location
     */
    public String toString() {
    	return "Tile at " + this.location;
    }

	public void moveNorth(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public void moveSouth(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public void moveNorthwest(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public void moveSoutheast(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public void moveSouthwest(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		System.out.println("center tile draws");
		if (terrain != null) terrain.draw();
		if (!tileables.isEmpty())
				for (Tileable t : tileables)
					t.draw();
	}
}
