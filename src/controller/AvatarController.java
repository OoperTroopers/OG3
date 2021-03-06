package controller;

import model.abilities.*;
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

import model.abilities.movement.*;
import model.entities.Avatar;
import model.entities.Entity;
import model.map.Tile;
import model.map.Tileable;


import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import view.view.Viewport;

public class AvatarController extends Controller {

    private Avatar avatar;
    private ArrayList<KeyListener> kbList;
    private HashMap<Direction, ExplicitAbility> directionAbilities;
    private Viewport view;

    public AvatarController(Avatar avatar){
       	this.view = ActiveGameViewport.getInstance();
       	this.avatar = avatar;
        kbList = new ArrayList<KeyListener>();
        this.directionAbilities = new HashMap<Direction, ExplicitAbility>();
        //this.statsController = new StatsController(avatar.getStats());
    }
    
    public AvatarController(Avatar avatar, ArrayList<KeyListener> kbList) {
    	super();
    	this.avatar = avatar;
    	this.kbList = kbList;
    	this.directionAbilities = new HashMap<Direction, ExplicitAbility>();
        //this.statsController = new StatsController(avatar.getStats());
    }
   
    public void setDefaultAbilityKeys() {
    	ExplicitAbility moveNorth = new MoveNorthAbility(avatar, 'w');
    	ExplicitAbility moveNorthwest = new MoveNorthwestAbility(avatar, 'q');
    	ExplicitAbility moveNortheast = new MoveNortheastAbility(avatar, 'e');
    	ExplicitAbility moveSouth = new MoveSouthAbility(avatar, 's');
    	ExplicitAbility moveSouthwest = new MoveSouthwestAbility(avatar, 'a');
    	ExplicitAbility moveSoutheast = new MoveSoutheastAbility(avatar, 'd');

		//KEYBINDING
		ExplicitAbility switchKey = new SwitchKeyAbility(avatar, 'm');
    	
    	ExplicitAbility scrollableMoveNorth = new ScrollableMoveNorthAbility('i');
    	ExplicitAbility scrollableMoveNortheast = new ScrollableMoveNortheastAbility('o');
    	ExplicitAbility scrollableMoveNorthwest = new ScrollableMoveNorthwestAbility('u');
    	ExplicitAbility scrollableMoveSouth = new ScrollableMoveSouthAbility('k');
    	ExplicitAbility scrollableMoveSoutheast = new ScrollableMoveSoutheastAbility('l');
    	ExplicitAbility scrollableMoveSouthwest = new ScrollableMoveSouthwestAbility('j');
    	ExplicitAbility attackAbility = new AttackAbility(avatar, '1');
    	ExplicitAbility bane = new Bane(avatar, '2');
    	ExplicitAbility bindWounds = new BindWounds(avatar, '3');
    	ExplicitAbility boon = new Boon(avatar, '4');
    	
    	// mounting
    	ExplicitAbility interactAbility = new InteractAbility(avatar, ' ');
    	


		avatar.addAbility(switchKey);

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
    	avatar.addAbility(attackAbility);
    	avatar.addAbility(bane);
    	avatar.addAbility(bindWounds);
    	avatar.addAbility(boon);
    	
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


	public void updateKeyBinding(ExplicitAbility ability, Direction direction){
		System.out.println("I GOT HERE!");
		ExplicitAbility oldAbility =  directionAbilities.remove(direction);
		KeyBinding oldKeyBinding = oldAbility.getKeyBinding();
		((Avatar)avatar).removeAbility(oldAbility);
		directionAbilities.put(direction, ability);
		avatar.addAbility(ability);
		ActiveGameViewport.getInstance().removeKeyListener(oldKeyBinding);
		ActiveGameViewport.getInstance().addSingleAvatarKeyBinding(ability.getKeyBinding());
	}

	public void removeFromKLSet(KeyBinding keyBinding){
		kbList.remove(keyBinding);
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

	@Override
	public Viewport getViewport() {
		return this.view;
	}
}
