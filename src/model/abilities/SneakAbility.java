package model.abilities;

import controller.ControllerAvatar;
import controller.KeyBinding;
import model.entities.Avatar;

public class SneakAbility implements Ability {
    private Avatar avatar;
    private KeyBinding keyBinding;
    private boolean isActivated;

    public SneakAbility(Avatar avatar, char keyToBind){
        this.avatar = avatar;
        this.keyBinding = new KeyBinding(keyToBind, this);
        isActivated = true;
    }
    @Override
    public void perform() {
        System.out.println("I AM VERY SNEAKY");
        this.avatar.moveSouth();
    }
    

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}