/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import java.awt.Image;

import view.modelview.tileable.TileableView;
import view.modelview.tileable.terrain.TerrainView;


/**
 * 
 * @author Jason Owens
 */
public abstract class Terrain {
    
	TileableView terrainView;
	
	public Terrain(TileableView terrainView) {
		this.terrainView = terrainView;
	}
    
    public abstract Terrain clone();
    public abstract void draw();
    /*
    public boolean canMove(Moveable m){
        
    }
    public boolean canMove(Entity e){
        
    }
    */
	public abstract void setLocation(Location location);
	public abstract Image getTerrainView();
}
