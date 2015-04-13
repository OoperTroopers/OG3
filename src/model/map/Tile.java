/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.entities.Entity;

/**
 * Tile represents the smallest discrete location an object can 
 * have in our game. Each tile has a reference to all of the tiles
 * near it. 
 * @author Jason Owens
 */
public class Tile {
    
    private Location location;
    private Terrain terrain;
    private ArrayList<Tileable> tileables;

    LinkedList<Entity> observers;

    private Tile north;
    private Tile northeast;
    private Tile northwest;
    private Tile south;
    private Tile southeast;
    private Tile southwest;


    
    public void affectAllTileables(Effect e){
        for(Tileable t: tileables){
            t.accept(e);
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
        
        return new MemTile(this, location, tCopy, copyOfList);
    }
    
    private List<Tileable> cloneTileables(){
        List<Tileable> copyOfList = new ArrayList<>();
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
        tileables.add(t);
    }

    
    
    /*
     * These functions are for getting references to nearby tiles. Be careful
     * of LoD violations.
     * @author Jason Owens
     */
    
    public Tile getNorth(){
        return north;
    }
    public Tile getNortheast(){
        return northeast;
    }
    public Tile getNorthwest(){
        return northwest;
    }
    public Tile getSouth(){
        return south;
    }
    public Tile getSoutheast(){
        return southeast;
    }
    public Tile getSouthwest(){
        return southwest;
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
    
    /**
     * 
     * @author Jason Owens
     */
    public void addOvserver(Entity e){
        
    }
    
    
    /**
     * notifies all of the Entities that can see this Tile. Use this method whenever
     * something visible about the tile changes.
     * @author Jason Owens
     */
    public void notifyObservers(){
        
        for(Entity e: observers){
            e.notify(this);
        }
    }

    
    /**
     * moves a Tileable north
     * @param aThis 
     */
    public void moveNorth(Entity aThis) {
        this.removeTileable(aThis);
        north.addTileable(aThis);
    }

    /**
     * moves a Tileable south
     * @param aThis 
     */
    public void moveSouth(Entity aThis) {
        this.removeTileable(aThis);
        south.addTileable(aThis);
    }

    /**
     * moves a Tileable northwest
     * @param aThis 
     */
    public void moveNorthwest(Entity aThis) {
        this.removeTileable(aThis);
        northwest.addTileable(aThis);
    }

    /**
     * moves a Tileable northeast
     * @param aThis 
     */
    public void moveNortheast(Entity aThis) {
        this.removeTileable(aThis);
        northeast.addTileable(aThis);
    }

    /**
     * moves a Tileable southeast
     * @param aThis 
     */
    public void moveSoutheast(Entity aThis) {
        this.removeTileable(aThis);
        southeast.addTileable(aThis);
    }

    /**
     * moves a Tileable southwest
     * @param aThis 
     */
    public void moveSouthwest(Entity aThis) {
        this.removeTileable(aThis);
        southwest.addTileable(aThis);
    }
    
    
}

