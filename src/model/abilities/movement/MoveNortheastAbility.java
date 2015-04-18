package model.abilities.movement;

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
    @Override
    public void perform() {
        entity.moveNortheast();
        System.out.println("I AM MOVING NORTHEAST");
    }

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}