package model.abilities;

import controller.ControllerAvatar;
import controller.KeyBinding;
import model.entities.Avatar;

public class AttackAbility implements Ability {
    private Avatar avatar;
    private KeyBinding keyBinding;

    public AttackAbility(Avatar avatar, char keyToBind){
        this.avatar = avatar;
        this.keyBinding = new KeyBinding(keyToBind, this);
    }

    @Override
    public void perform() {
        System.out.println("I AM ATTACKING YOU!");
    }

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}