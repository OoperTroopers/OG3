/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;
import modelview.TerrainView;
import modelview.GrassTerrainView;
/**
 *
 * @author Jason Owens
 */
public class GrassTerrain extends Terrain{
	
    public GrassTerrain() {
    	terrainView = new GrassTerrainView();
    }
    
    @Override
    public Terrain clone() {
        return new GrassTerrain();
    }
    
    @Override
    public void draw() {
    	terrainView.draw();
    }
    
}
