/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import java.awt.Image;
import model.effects.Effect;
import view.modelview.tileableview.MountainTerrainView;

/**
 *
 * @author Doherty
 */
public class MountainTerrain extends Terrain {
    static MountainTerrainView view = new MountainTerrainView();

    public MountainTerrain() {
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
    public void removeFromTile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tile getContainingTile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isTraversable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
