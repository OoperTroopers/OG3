package model.abilities.movement;

import view.view.ActiveGameViewport;
import controller.ControllerAvatar;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveNortheastAbility extends ExplicitAbility {
    private Entity entity;
    private KeyBinding keyBinding;

    public MoveNortheastAbility(Entity entity, char keyToBind){
        this.entity = entity;
        this.keyBinding = new KeyBinding(keyToBind, this);
    }
    
    public MoveNortheastAbility(Entity entity){
    	this.entity = entity;
    }
    
    @Override
    public void perform() {
    	if (this.isActivated()) {
	        entity.moveNortheast();
	        entity.setDirection(5);
    	}
    }

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}