package model.abilities.movement;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.AvatarController;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;
import model.map.Tile;


public class ScrollableMoveNortheastAbility extends ExplicitAbility {
    private KeyBinding keyBinding;

    public ScrollableMoveNortheastAbility(char keyToBind){
        this.keyBinding = new KeyBinding(keyToBind, this);
    }
    @Override
    public void perform() {
        if (this.isActivated()) {
        	Tile current = ActiveGameViewport.getInstance().getScrollableTile();
        	if (current.getNeighbor(Direction.NORTHEAST) == null) return;
        	current = current.getNeighbor(Direction.NORTHEAST);
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