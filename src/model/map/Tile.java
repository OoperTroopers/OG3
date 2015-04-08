/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jason Owens
 */
class Tile {
    
private Location location;
private Terrain terrain;
private ArrayList<Tileable> tileables;


private Tile north;
private Tile northEast;
private Tile northWest;
private Tile south;
private Tile southEast;
private Tile southWest;

    public void affectAllTileables(Effect e){

    }
    public MemTile clone(){
        
        List<Tileable> copyOfList = new ArrayList<>();
        for(Tileable t: tileables){
            copyOfList.add(t.clone());
        }
        Terrain tCopy = new Terrain();
        
        return new MemTile(this, location, tCopy, copyOfList);
    }
    public void removeTileable(Tileable t){
        tileables.remove(t);
    }
    public void addTileable(Tileable t){
        tileables.add(t);
    }
}

