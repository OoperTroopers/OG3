package model.map;

import java.awt.Image;
import model.effects.Effect;
import view.modelview.tileableview.WaterTerrainView;

/**
 *
 * @author Doherty
 */
public class WaterTerrain extends Terrain {

    static WaterTerrainView view = new WaterTerrainView();

    public WaterTerrain() {
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
