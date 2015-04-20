/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import java.awt.Image;

import model.entities.Avatar;

import view.modelview.tile.TileView;
import view.modelview.tileable.TileableView;


/**
 * 
 * @author Jason Owens
 */
public abstract class Terrain implements Tileable {
    
	TileableView terrainView;
	
	public Terrain(TileableView terrainView) {
		this.terrainView = terrainView;
	}
    
    public abstract Terrain clone();
    /*
    public boolean canMove(Moveable m){
        
    }
    public boolean canMove(Entity e){
        
    }
    */
	public abstract void setLocation(Location location);
	public void sendToView(TileView tileView) {
		tileView.accept(terrainView);
	}
	
	public void removeFromView(TileView tileView) {}
	public void acceptAvatar(Avatar avatar) {}
	public void acceptAvatarInteraction(Avatar avatar) {}
}
