package model.abilities.movement;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.AvatarController;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveNorthwestAbility extends ExplicitAbility {
    private Entity entity;

    public MoveNorthwestAbility(Entity entity, char keyToBind){
        this.entity = entity;
        setKeyBinding( new KeyBinding(keyToBind, this));
    }
    
    public MoveNorthwestAbility(Entity entity){
    	this.entity = entity;
    }
    
    @Override
    public void perform() {
        if (this.isActivated()) {
        	entity.moveNorthwest();
        	entity.setDirection(Direction.NORTHWEST);
            System.out.println("I AM MOVING NORTHWEST");
        }
    }

    @Override
    public void attachToController(AvatarController controlAvatar) {
        controlAvatar.addToKLSet(getKeyBinding());
    }
}