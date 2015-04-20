package model.abilities.movement;

import view.view.ActiveGameViewport;
import controller.ControllerAvatar;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveNorthAbility extends ExplicitAbility {
    private Entity entity;
    private KeyBinding keyBinding;

    public MoveNorthAbility(Entity entity, char keyToBind){
        this.entity = entity;
        this.keyBinding = new KeyBinding(keyToBind, this);
    }
    
    public MoveNorthAbility(Entity entity){
    	this.entity = entity;
    }
    
    @Override
    public void perform() {
        if (this.isActivated()) {
        	entity.moveNorth();
        	entity.setDirection(6);
        }
    }

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}