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
    
    private Tile myTile;
    private Location location;
    private Terrain terrain;
    private List<Tileable> tileables;
    
    
    public MemTile(Tile clonedTile, Location l, Terrain t, List<Tileable> tileables){
        this.myTile = clonedTile;
        this.location = l;
        this.terrain = t;
        this.tileables = tileables;
    }
    
    /**
     * TODO
     */
    public void update(){
        
    }
}
