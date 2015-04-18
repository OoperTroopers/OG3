package model.abilities.movement;

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
    @Override
    public void perform() {
        entity.moveSouth();
        System.out.println("I AM MOVING SOUTH");
    }

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}