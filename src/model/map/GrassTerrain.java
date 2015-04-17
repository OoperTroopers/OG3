/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import view.modelview.tileable.terrain.GrassTerrainView;
import view.modelview.tileable.terrain.TerrainView;

/**
 *
 * @author Jason Owens
 */
public class GrassTerrain extends Terrain{
	GrassTerrainView terrainView;
	
    public GrassTerrain() {
    	terrainView = new GrassTerrainView();
    }
    
    @Override
    public Terrain clone() {
        return new GrassTerrain();
    }
    
    //@Override
    //public void draw() {
    //	TerrainView.draw();
    //}
    
    public void drawView() {
    	terrainView.draw();
    }
}
