package model.abilities.movement;

import view.view.ActiveGameViewport;
import controller.ControllerAvatar;
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
    @Override
    public void perform() {
        if (this.isActivated()) {
        	entity.moveSoutheast();
        	entity.setDirection(4);
        }
    }

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}