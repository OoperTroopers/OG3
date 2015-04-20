package model.abilities.movement;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.AvatarController;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveSoutheastAbility extends ExplicitAbility {
    private Entity entity;
    private KeyBinding keyBinding;

    public MoveSoutheastAbility(Entity entity, char keyToBind){
        this.entity = entity;
        this.keyBinding = new KeyBinding(keyToBind, this);
    }
    
    public MoveSoutheastAbility(Entity entity){
    	this.entity = entity;
    }
    
    @Override
    public void perform() {
        if (this.isActivated()) {
        	entity.moveSoutheast();
        	entity.setDirection(Direction.SOUTHEAST);
        }
    }

    @Override
    public void attachToController(AvatarController controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}