package model.abilities.movement;

import view.view.ActiveGameViewport;
import controller.ControllerAvatar;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveSouthAbility extends ExplicitAbility {
    private Entity entity;
    private KeyBinding keyBinding;

    public MoveSouthAbility(Entity entity, char keyToBind){
        this.entity = entity;
        this.keyBinding = new KeyBinding(keyToBind, this);
    }
    
    public MoveSouthAbility(Entity entity){
    	this.entity = entity;
    }
    
    @Override
    public void perform() {
        if (this.isActivated()) {
        	entity.moveSouth();
        	entity.setDirection(3);
        }
    }

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}