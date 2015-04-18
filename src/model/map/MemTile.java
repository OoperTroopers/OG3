/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import java.util.List;

/**
 * The MemTile will be what the view uses to print things to the screen.
 * Essentially, each MemTile is a copy of the Tile it represents at the moment
 * the avatar saw it
 * @author Jason Owens
 */
public class MemTile {
    
    private boolean hasBeenSeen;
    
    private Tile myTile;
    private Location location;
    // private Terrain terrain;
    private List<Tileable> tileables;
    
    private MemTile north;
    private MemTile northeast;
    private MemTile northwest;
    private MemTile south;
    private MemTile southeast;
    private MemTile southwest;
    
    
    public MemTile(Tile clonedTile){
        this.myTile = clonedTile;
        this.location = clonedTile.getLocationClone();
        // this.terrain = clonedTile.getTerrainClone();
        this.tileables = clonedTile.getTileablesClone();
        //this.location = l;
       // this.terrain = t;
        //this.tileables = tileables;
    }
    
    /**
     * TODO
     */
    public void update(){
        this.location = myTile.getLocationClone();
        // this.terrain = myTile.getTerrainClone();
        this.tileables = tileables;
    }
    
    /**
     * 
     * @author Jason Owens
     * @return whether or not the avatar has seen this tile
     */
    public boolean hasBeenSeen(){
        return hasBeenSeen;
    }
    
    /**
     * 
     * @author Jason Owens
     * @return the whtehter the MemTile north of this one has been seen and exists
     */
    public boolean hasNorth(){
        if(north == null){
            return false;
        }
        else if(north.hasBeenSeen()){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 
     * @author Jason Owens
     * @return the MemTile northeast of this one
     */
    public boolean hasNortheast(){
        if(northeast == null){
            return false;
        }
        else if(northeast.hasBeenSeen()){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 
     * @author Jason Owens
     * @return the MemTile northwest of this one
     */
    public boolean hasNorthwest(){
        if(northwest == null){
            return false;
        }
        else if(northwest.hasBeenSeen()){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 
     * @author Jason Owens
     * @return the MemTile south of this one
     */
    public boolean hasSouth(){
        if(south == null){
            return false;
        }
        else if(south.hasBeenSeen()){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 
     * @author Jason Owens
     * @return the MemTile southwest of this one
     */
    public boolean hasSouthwest(){
        if(southwest == null){
            return false;
        }
        else if(southwest.hasBeenSeen()){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 
     * @author Jason Owens
     * @return the MemTile southwest of this one
     */
    public boolean hasSoutheast(){
        if(southeast == null){
            return false;
        }
        else if(southeast.hasBeenSeen()){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    
    /**
     * 
     * @author Jason Owens
     * @return the MemTile north of this one
     */
    public MemTile getNorth(){
        
        return north;
    }
    /**
     * 
     * @author Jason Owens
     * @return the MemTile northeast of this one
     */
    public MemTile getNortheast(){
        return northeast;
    }
    /**
     * 
     * @author Jason Owens
     * @return the MemTile northwest of this one
     */
    public MemTile getNorthwest(){
        return northeast;
    }
    /**
     * 
     * @author Jason Owens
     * @return the MemTile south of this one
     */
    public MemTile getSouth(){
        return south;
    }
    /**
     * 
     * @author Jason Owens
     * @return the MemTile southwest of this one
     */
    public MemTile getSouthwest(){
        return southwest;
    }
    /**
     * 
     * @author Jason Owens
     * @return the MemTile southwest of this one
     */
    public MemTile getSoutheast(){
        return southeast;
    }

    public Location getLocation() {
        return location;
    }
    
    /**
     * TODO tie this with an actual view object
     * 
     */
    public void print(){
        // myView.print(this);
    }
       
    
}
