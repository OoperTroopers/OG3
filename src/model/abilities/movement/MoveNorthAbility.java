package model.abilities.movement;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.AvatarController;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveNorthAbility extends ExplicitAbility {
    private Entity entity;

    public MoveNorthAbility(Entity entity, char keyToBind){
        this.entity = entity;
        setKeyBinding( new KeyBinding(keyToBind, this));
    }
    
    public MoveNorthAbility(Entity entity){
    	this.entity = entity;
    }
    
    @Override
    public void perform() {
        if (this.isActivated()) {
        	entity.moveNorth();
        	entity.setDirection(Direction.NORTH);
            System.out.println("I AM MOVING NORTH");
        }
    }

    @Override

    public void attachToController(AvatarController controlAvatar) {
        controlAvatar.addToKLSet(getKeyBinding());
    }
}