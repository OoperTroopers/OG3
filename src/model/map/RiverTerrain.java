/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import controller.GameTimer;
import model.effects.Effect;
import model.effects.RiverEffect;
import model.entities.Avatar;
import model.entities.Entity;
import utilities.TileAlgorithm.Direction;
import view.modelview.tileable.terrain.RiverTerrainView;

/**
 *
 * @author Doherty
 */
public class RiverTerrain extends Terrain {
    static RiverTerrainView view = new RiverTerrainView();
    Direction direction;
    GameTimer untilEffect;

    public RiverTerrain() {
    	super(view);
    	this.direction = Direction.SOUTH;
    }
    
    public RiverTerrain(Direction direction) {
    	super(view);
    	this.direction = direction;
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
        return true;
    }
    
    @Override
    public void acceptAvatar(Avatar avatar) {
    	untilEffect = GameTimer.getInstance();
    	untilEffect.addRunnable(new RiverEffect(direction, avatar), 1000);
    }
    
}
