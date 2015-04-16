/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import view.modelview.tileable.terrain.TerrainView;

/**
 * 
 * @author Jason Owens
 */
public abstract class Terrain {
    
    public TerrainView terrainView;
    public abstract Terrain clone();
    
    /*
    public boolean canMove(Moveable m){
        
    }
    public boolean canMove(Entity e){
        
    }
    */
}
