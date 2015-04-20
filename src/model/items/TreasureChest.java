package model.items;

import view.modelview.tileable.items.TreasureChestView;
import model.effects.Effect;
import model.entities.Entity;
import model.map.Tile;
import model.map.Tileable;
import model.statistics.Statistics;

public class TreasureChest extends InteractiveItem {

	private boolean chestHasBeenOpened;
	
	public TreasureChest() {
		super(new TreasureChestView());
		this.chestHasBeenOpened = false;
	}
	
	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);
	}

	@Override
	public boolean isTraversable() {
		return false;
	}

	@Override
	public void interact(Entity entity) {
		// LoD violated here
		if (!this.hasBeenActivated()) {
			Statistics stats = entity.getStats();
			stats.increaseExperience(500);
			this.setActivated();
		}
	}

	@Override
	public boolean isInteractive(Entity entity) {
		// LoD violated here
		Statistics stats = entity.getStats();
		if (stats.getCurrentLevel() >= 5) return true;
		return false;
	}

	@Override
	public boolean isPassable() {
		return false;
	}

	@Override
	public Tileable clone() {
		return new TreasureChest();
	}
	
	private boolean hasBeenActivated() {
		return this.chestHasBeenOpened;
	}
	
	private void setActivated() {
		this.chestHasBeenOpened = true;
	}
	
	public String toString() {
		return "Item=TreasureChest";
	}

}
