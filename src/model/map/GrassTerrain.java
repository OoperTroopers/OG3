/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import java.awt.Image;

import view.modelview.tileable.terrain.GrassTerrainView;
import view.modelview.tileable.terrain.TerrainView;
import view.tools.LocationPositionConverter;
import view.tools.ViewPosition;

/**
 *
 * @author Jason Owens
 */
public class GrassTerrain extends Terrain{
	static GrassTerrainView view = new GrassTerrainView();
	
    public GrassTerrain() {
    	super(view);
    }
    
    @Override
    public Terrain clone() {
        return new GrassTerrain();
    }
    
    public void draw() {
    	System.out.println("Grass Terrain Draw called");
    	view.draw();
    }
    
    public void draw(Location location) {
    	
    }
    
    public void setLocation(Location location) {
    	//view.setPosition(LocationPositionConverter.convert(location));
    }
    
    public Image getTerrainView() { return view.getImage(); }
    
}
