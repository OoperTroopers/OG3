package model.abilities.movement;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.AvatarController;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveSouthAbility extends ExplicitAbility {
    private Entity entity;

    public MoveSouthAbility(Entity entity, char keyToBind){
        this.entity = entity;
        setKeyBinding( new KeyBinding(keyToBind, this));
    }
    
    public MoveSouthAbility(Entity entity){
    	this.entity = entity;
    }
    
    @Override
    public void perform() {
        if (this.isActivated()) {
        	entity.moveSouth();
        	entity.setDirection(Direction.SOUTH);
            System.out.println("I AM MOVING SOUTH");
        }
    }

    @Override
    public void attachToController(AvatarController controlAvatar) {
        controlAvatar.addToKLSet(getKeyBinding());

    }
}