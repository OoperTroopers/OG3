/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

/**
 * The purpose of journal is store the Avatar's memory of the Tiles that it has seen.
 * 
 * @author Jason Owens
 */
public class Journal{
    private MemTile currentTile;
    
    
    /**
     * Moves the view north
     * @return whether or not the tile north of this one has been seen
     */
    public boolean thinkNorth(){
        if(currentTile.hasNorth()){
            currentTile = currentTile.getNorth();
            return true;
        }
        return false;
    }
    public boolean thinkNortheast(){
        if(currentTile.hasNortheast()){
            currentTile = currentTile.getNortheast();
            return true;
        }
        return false;
    }
    public boolean thinkNorthwest(){
        if(currentTile.hasNorthwest()){
            currentTile = currentTile.getNorthwest();
            return true;
        }
        return false;
    }
    public boolean thinkSouth(){
        if(currentTile.hasSouth()){
            currentTile = currentTile.getSouth();
            return true;
        }
        return false;
    }
    public boolean thinkSoutheast(){
        if(currentTile.hasSoutheast()){
            currentTile = currentTile.getSoutheast();
            return true;
        }
        return false;
    }
    public boolean thinkSouthwest(){
        if(currentTile.hasSouthwest()){
            currentTile = currentTile.getSouthwest();
            return true;
        }
        return false;
    }
}
