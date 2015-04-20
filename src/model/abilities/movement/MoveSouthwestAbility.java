package model.abilities.movement;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.ControllerAvatar;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveSouthwestAbility extends ExplicitAbility {
    private Entity entity;
    private KeyBinding keyBinding;

    public MoveSouthwestAbility(Entity entity, char keyToBind){
        this.entity = entity;
        this.keyBinding = new KeyBinding(keyToBind, this);
    }
    
    public MoveSouthwestAbility(Entity entity){
    	this.entity = entity;
    }
    
    @Override
    public void perform() {
        if (this.isActivated()) {
        	entity.moveSouthwest();
        	entity.setDirection(Direction.SOUTHWEST);
        }
    }

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}