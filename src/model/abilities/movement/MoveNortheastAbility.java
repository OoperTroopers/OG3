package model.abilities.movement;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.AvatarController;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveNortheastAbility extends ExplicitAbility {
    private Entity entity;

    public MoveNortheastAbility(Entity entity, char keyToBind){
        this.entity = entity;
        setKeyBinding( new KeyBinding(keyToBind, this));
    }
    
    public MoveNortheastAbility(Entity entity){
    	this.entity = entity;
    }
    
    @Override
    public void perform() {
    	if (this.isActivated()) {
	        entity.moveNortheast();
	        entity.setDirection(Direction.NORTHEAST);
	        System.out.println("I AM MOVING NORTHEAST");
    	}
    }

    @Override

    public void attachToController(AvatarController controlAvatar) {
        controlAvatar.addToKLSet(getKeyBinding());
    }
}