/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import model.effects.Effect;
import view.modelview.tileable.terrain.RiverTerrainView;

/**
 *
 * @author Doherty
 */
public class RiverTerrain extends Terrain {
    static RiverTerrainView view = new RiverTerrainView();

    public RiverTerrain() {
    	super(view);
    }
    
    @Override
    public Terrain clone() {
        return new GrassTerrain();
    }
    
    public void draw(Location location) {
        
    }
    
    @Override
    public void setLocation(Location location) {
    	//view.setPosition(LocationPositionConverter.convert(location));
    }

    @Override
    public void acceptEffect(Effect e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isTraversable() {
        return false;
    }
    
}
