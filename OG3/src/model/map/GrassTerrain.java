/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import model.effects.Effect;
import view.modelview.tile.TileView;
import view.modelview.tileable.terrain.GrassTerrainView;

/**
 *
 * @author Jason Owens
 */
public class GrassTerrain extends Terrain {
    
    static GrassTerrainView view = new GrassTerrainView();

    public GrassTerrain() {
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
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isTraversable() {
        return true;
    }

	@Override
	public void removeFromView(TileView tileView) {
		tileView.remove(view);
		
	}
}
