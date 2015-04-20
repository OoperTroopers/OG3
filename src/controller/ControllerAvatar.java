package controller;

import model.abilities.Ability;
import model.abilities.ExplicitAbility;
import model.abilities.InteractAbility;
import model.abilities.MountAbility;
import model.abilities.movement.MoveNorthAbility;
import model.abilities.movement.MoveNortheastAbility;
import model.abilities.movement.MoveNorthwestAbility;
import model.abilities.movement.MoveSouthAbility;
import model.abilities.movement.MoveSoutheastAbility;
import model.abilities.movement.MoveSouthwestAbility;
import model.abilities.movement.ScrollableMoveNorthAbility;
import model.abilities.movement.ScrollableMoveNortheastAbility;
import model.abilities.movement.ScrollableMoveNorthwestAbility;
import model.abilities.movement.ScrollableMoveSouthAbility;
import model.abilities.movement.ScrollableMoveSoutheastAbility;
import model.abilities.movement.ScrollableMoveSouthwestAbility;
import model.entities.Avatar;
import model.entities.Entity;
import model.map.Tile;
import model.map.Tileable;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

import utilities.TileAlgorithm.Direction;

/**
 * Created by Adam on 4/13/2015.
 */
public class ControllerAvatar {

	private Avatar avatar;
    private ArrayList<KeyListener> kbList;
    private HashMap<Direction, ExplicitAbility> directionAbilities;

    public ControllerAvatar(Avatar avatar){
       	super();
       	this.avatar = avatar;
        kbList = new ArrayList<KeyListener>();
        this.directionAbilities = new HashMap<Direction, ExplicitAbility>();
    }
    
    public ControllerAvatar(Avatar avatar, ArrayList<KeyListener> kbList) {
    	super();
    	this.avatar = avatar;
    	this.kbList = kbList;
    	this.directionAbilities = new HashMap<Direction, ExplicitAbility>();
    }
   
    public void setDefaultAbilityKeys() {
    	ExplicitAbility moveNorth = new MoveNorthAbility(avatar, 'w');
    	ExplicitAbility moveNorthwest = new MoveNorthwestAbility(avatar, 'q');
    	ExplicitAbility moveNortheast = new MoveNortheastAbility(avatar, 'e');
    	ExplicitAbility moveSouth = new MoveSouthAbility(avatar, 's');
    	ExplicitAbility moveSouthwest = new MoveSouthwestAbility(avatar, 'a');
    	ExplicitAbility moveSoutheast = new MoveSoutheastAbility(avatar, 'd');
    	
    	ExplicitAbility scrollableMoveNorth = new ScrollableMoveNorthAbility('i');
    	ExplicitAbility scrollableMoveNortheast = new ScrollableMoveNortheastAbility('o');
    	ExplicitAbility scrollableMoveNorthwest = new ScrollableMoveNorthwestAbility('u');
    	ExplicitAbility scrollableMoveSouth = new ScrollableMoveSouthAbility('k');
    	ExplicitAbility scrollableMoveSoutheast = new ScrollableMoveSoutheastAbility('l');
    	ExplicitAbility scrollableMoveSouthwest = new ScrollableMoveSouthwestAbility('j');
    	
    	// mounting
    	ExplicitAbility interactAbility = new InteractAbility(avatar, ' ');
    	
    	avatar.addAbility(moveNorth);
    	avatar.addAbility(moveNorthwest);
    	avatar.addAbility(moveNortheast);
    	avatar.addAbility(moveSouth);
    	avatar.addAbility(moveSouthwest);
    	avatar.addAbility(moveSoutheast);
    	
    	avatar.addAbility(scrollableMoveNorth);
    	avatar.addAbility(scrollableMoveNortheast);
    	avatar.addAbility(scrollableMoveNorthwest);
    	avatar.addAbility(scrollableMoveSouth);
    	avatar.addAbility(scrollableMoveSoutheast);
    	avatar.addAbility(scrollableMoveSouthwest);
    	
    	avatar.addAbility(interactAbility);
    	
    	directionAbilities.put(Direction.NORTH, moveNorth); 
    	directionAbilities.put(Direction.NORTHWEST, moveNorthwest); 
    	directionAbilities.put(Direction.NORTHEAST, moveNortheast); 
    	directionAbilities.put(Direction.SOUTH, moveSouth); 
    	directionAbilities.put(Direction.SOUTHWEST, moveSouthwest); 
    	directionAbilities.put(Direction.SOUTHEAST, moveSoutheast); 
    }

    public void addToKLSet(KeyBinding keyBinding){
        kbList.add(keyBinding);
    }
    
    public ArrayList<KeyListener> getKbList(){
        return kbList;
    }
    
    public void update(Entity avatar, Tile tile) {
    	for (Direction direction : Direction.values()) {
    		Tile neighbor = tile.getNeighbor(direction);
    		boolean flag = true;
    		for (Tileable tileable : neighbor.getTileables()) {
    			if (!tileable.isTraversable()) flag = false;
    		}
    		if (flag) {
    			directionAbilities.get(direction).activate();
    		} else {
    			directionAbilities.get(direction).deactivate();
    		}
    	}
    }
}
