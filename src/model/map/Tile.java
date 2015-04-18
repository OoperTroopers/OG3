/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import java.awt.Image;
import java.util.*;

import model.effects.Effect;
import model.entities.Entity;
import utilities.TileAlgorithm;
import utilities.TileAlgorithm.Direction;
import view.modelview.tile.TileView;
import view.modelview.tileable.TileableView;
import view.view.ActiveGameViewport;

/**
 * Tile represents the smallest discrete location an object can 
 * have in our game. Each tile has a reference to all of the tiles
 * near it. 
 * @author Jason Owens, Cormac McCarthy
 */
public class Tile {
    
    private Location location;
    // private Terrain terrain;
    	// jason, shouldn't this be inside of tileables?
    	// - danny
    
    	// update: we're doing it. sorry jason.
    	// also, suck it.
    	// - big d
    
    private HashMap<Direction, Tile> neighbors;
    private ArrayList<Tileable> tileables;
    private TileView tileView;
    
    LinkedList<Entity> observers;
    
    public Tile() {
    	this.location = new Location(-200, -200, -200);
    	this.neighbors = new HashMap<Direction, Tile>();
    	tileView = new TileView();
    	tileables = new ArrayList<Tileable>();
    	this.addTileable(new GrassTerrain());
    }
    
    public Tile(int x, int y, int z) {
    	this.neighbors = new HashMap<Direction, Tile>();
    	this.setLocation(x, y, z);
    	tileView = new TileView();
    	tileables = new ArrayList<Tileable>();
    	this.addTileable(new GrassTerrain());
    }
    
    public Tile(int x, int y, int z, Terrain terrain) {
    	this.neighbors = new HashMap<Direction, Tile>();
    	this.setLocation(x, y, z);
    	tileables = new ArrayList<Tileable>();
    	tileView = new TileView();
    	this.addTileable(terrain);
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
        // Terrain tCopy = getTerrainClone();
        Location lCopy = getLocationClone();
        
        return new MemTile(this);
        // return new MemTile(this, location, tCopy, copyOfList);
        // return null;//new MemTile(this, location, tCopy, copyOfList);
    }
    
    public ArrayList<Tileable> getTileables() {
    	return this.tileables;
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
        t.removeFromView(tileView);
    }
    
    /**
     * Adds a Tileable to the tile
     * @param t the tileable to be added
     */   
    public void addTileable(Tileable t){
        tileables.add(t);
        t.sendToView(tileView);
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
    
    /*public Terrain getTerrainClone() {
        return this.terrain.clone();
    }*/
    
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
     * Sets the Location of a Tile.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     */
    public void setLocation(int x, int y, int z) {
    	this.location = new Location(x, y, z);
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

	public TileView getTileView() {
		return tileView;
	}

	public List<TileableView> getTileableViews() {
		return tileView.getList();
	}
}
