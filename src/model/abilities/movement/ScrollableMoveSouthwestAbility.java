package model.abilities.movement;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.AvatarController;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;
import model.map.Tile;


public class ScrollableMoveSouthwestAbility extends ExplicitAbility {
    private KeyBinding keyBinding;

    public ScrollableMoveSouthwestAbility(char keyToBind){
        this.keyBinding = new KeyBinding(keyToBind, this);
    }
    @Override
    public void perform() {
        if (this.isActivated()) {
        	Tile current = ActiveGameViewport.getInstance().getScrollableTile();
        	if (current.getNeighbor(Direction.SOUTHWEST) == null) return;
        	current = current.getNeighbor(Direction.SOUTHWEST);
        	ActiveGameViewport.getInstance().setScrollableTile(current);
        	ActiveGameViewport.getInstance().activateScrollableTile();   
        	ActiveGameViewport.getInstance().repaint();
        }
    }

    @Override
    public void attachToController(AvatarController controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}