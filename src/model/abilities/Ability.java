package model.abilities;

import controller.ControllerAvatar;

public interface Ability {
    void perform();
    void attachToController(ControllerAvatar controlAvatar);
}
