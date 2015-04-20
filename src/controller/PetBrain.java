package controller;

import java.util.HashMap;

import utilities.TileAlgorithm.Direction;
import model.abilities.ExplicitAbility;
import model.abilities.movement.MoveNorthAbility;
import model.abilities.movement.MoveNortheastAbility;
import model.abilities.movement.MoveNorthwestAbility;
import model.abilities.movement.MoveSouthAbility;
import model.abilities.movement.MoveSoutheastAbility;
import model.abilities.movement.MoveSouthwestAbility;
import model.entities.Avatar;
import model.entities.Entity;
import model.entities.Pet;
import model.map.Tile;
import model.map.Tileable;

public class PetBrain extends Brain{

	private Pet pet;
    private HashMap<Direction, ExplicitAbility> directionAbilities;

    private GameTimer hivemind;
    private Avatar master;
    
    private boolean isFollowing;
	
	public PetBrain(Pet pet){
		this.pet = pet;
        this.directionAbilities = new HashMap<Direction, ExplicitAbility>();
        setDefaultAbilityKeys();
        
        hivemind = GameTimer.getInstance();
        hivemind.addRunnable(this, 300);
        isFollowing = true;
       
	}
	
	public void acceptMaster(Avatar a){
		master = a;
	}

	@Override
	public void run() {
		 //System.out.println("PETTTTTTTT");
		if(master != null){
			int distanceToOwner = pet.distanceToOwner();
			if( distanceToOwner > 2){
				isFollowing = true;
			}
			else if(distanceToOwner == 1){
				isFollowing = false;
			}
			if(isFollowing){
				directionAbilities.get(pet.follow()).perform();//perform();
			}
			else{
				Direction myDirection = pet.follow();
				while(myDirection == pet.follow()){
					int index = (int)(6*Math.random());
					myDirection = Direction.values()[index];
				}
				directionAbilities.get(myDirection).perform();
				updateMovements(pet.getTile());
			}
		}
	}
	
	public void updateMovements(Tile tile) {
    	for (Direction direction : Direction.values()) {
    		boolean flag = true;
    		//if(direction == pet.follow()) flag = true;
    		if (flag) {
    			directionAbilities.get(direction).activate();
    		} else {
    			directionAbilities.get(direction).deactivate();
    		}
    	}
    }

	public void setDefaultAbilityKeys() {
		
		ExplicitAbility moveNorth = new MoveNorthAbility(pet);
    	ExplicitAbility moveNorthwest = new MoveNorthwestAbility(pet);
    	ExplicitAbility moveNortheast = new MoveNortheastAbility(pet);
    	ExplicitAbility moveSouth = new MoveSouthAbility(pet);
    	ExplicitAbility moveSouthwest = new MoveSouthwestAbility(pet);
    	ExplicitAbility moveSoutheast = new MoveSoutheastAbility(pet);
    	
    	pet.addAbility(moveNorth);
    	pet.addAbility(moveNorthwest);
    	pet.addAbility(moveNortheast);
    	pet.addAbility(moveSouth);
    	pet.addAbility(moveSouthwest);
    	pet.addAbility(moveSoutheast);

    	directionAbilities.put(Direction.NORTH, moveNorth); 
    	directionAbilities.put(Direction.NORTHWEST, moveNorthwest); 
    	directionAbilities.put(Direction.NORTHEAST, moveNortheast); 
    	directionAbilities.put(Direction.SOUTH, moveSouth); 
    	directionAbilities.put(Direction.SOUTHWEST, moveSouthwest); 
    	directionAbilities.put(Direction.SOUTHEAST, moveSoutheast);
    	
    	

	}
}