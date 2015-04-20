package model.abilities.movement;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.AvatarController;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveSouthwestAbility extends ExplicitAbility {
    private Entity entity;

    public MoveSouthwestAbility(Entity entity, char keyToBind){
        this.entity = entity;
        setKeyBinding( new KeyBinding(keyToBind, this));
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
    public void attachToController(AvatarController controlAvatar) {
        controlAvatar.addToKLSet(getKeyBinding());
    }
}