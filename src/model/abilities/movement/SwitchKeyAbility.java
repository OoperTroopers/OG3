package model.abilities.movement;

import controller.AvatarController;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.effects.Effect;
import model.entities.Avatar;
import model.entities.Entity;
import utilities.TileAlgorithm;

/**
 * Created by Adam on 4/19/2015.
 */
public class SwitchKeyAbility extends ExplicitAbility {

    private boolean activated;
    private Effect effect;
    private Entity avatar;

    public SwitchKeyAbility() {
        super();
        setName("Explicit Ability");
        this.activated = true;
        this.effect = null;
    }

    public SwitchKeyAbility(Entity avatar, char keyToBind) {
        super();
        this.avatar = avatar;
        setName("Explicit Ability");
        setKeyBinding( new KeyBinding(keyToBind, this));
        this.activated = true;
        this.effect = null;
    }

    public void attachToController(AvatarController controlAvatar) {
        controlAvatar.addToKLSet(getKeyBinding());
    }
    public void removeFromController(AvatarController controllerAvatar){
        controllerAvatar.removeFromKLSet(getKeyBinding());
    }

    public Effect getEffect() {
        return effect;
    }
    public void setEffect(Effect effect) {
        this.effect = effect;
    }
    @Override
    public void perform(){
        System.out.println("IT WORKED!");
        ((Avatar) avatar).updateKeyBinding(new MoveSouthAbility(avatar, 'l'), TileAlgorithm.Direction.SOUTH);

    }
}
