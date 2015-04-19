package model.abilities.movement;

import view.view.ActiveGameViewport;
import controller.ControllerAvatar;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;


public class MoveNorthwestAbility extends ExplicitAbility {
    private Entity entity;
    private KeyBinding keyBinding;

    public MoveNorthwestAbility(Entity entity, char keyToBind){
        this.entity = entity;
        this.keyBinding = new KeyBinding(keyToBind, this);
    }
    @Override
    public void perform() {
        if (this.isActivated()) {
        	entity.moveNorthwest();
        	entity.setDirection(1);
            System.out.println("I AM MOVING NORTHWEST");
        }
    }

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}