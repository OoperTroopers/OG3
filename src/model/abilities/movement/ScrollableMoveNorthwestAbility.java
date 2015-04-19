package model.abilities.movement;

import utilities.TileAlgorithm.Direction;
import view.view.ActiveGameViewport;
import controller.ControllerAvatar;
import controller.KeyBinding;
import model.abilities.ExplicitAbility;
import model.entities.Entity;
import model.map.Tile;


public class ScrollableMoveNorthwestAbility extends ExplicitAbility {
    private KeyBinding keyBinding;

    public ScrollableMoveNorthwestAbility(char keyToBind){
        this.keyBinding = new KeyBinding(keyToBind, this);
    }
    @Override
    public void perform() {
        if (this.isActivated()) {
        	Tile current = ActiveGameViewport.getInstance().getScrollableTile();
        	current = current.getNeighbor(Direction.NORTHWEST);
        	ActiveGameViewport.getInstance().setScrollableTile(current);
        	ActiveGameViewport.getInstance().activateScrollableTile();   
        	ActiveGameViewport.getInstance().repaint();
            System.out.println("SCROLLABLE MOVING NORTHWEST");
        }
    }

    @Override
    public void attachToController(ControllerAvatar controlAvatar) {
        controlAvatar.addToKLSet(keyBinding);
    }
}