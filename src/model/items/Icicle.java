package model.items;

import model.effects.FrostbiteEffect;
import model.entities.Entity;
import view.modelview.tileable.TileableView;
import view.modelview.tileable.items.IcicleView;

public class Icicle extends TimedItem {
	public Icicle() {
		super(new IcicleView(), new FrostbiteEffect());
	}
	
	public Icicle(int occurrences) {
		super(new IcicleView(), new FrostbiteEffect(), occurrences);
	}
	
	@Override
	public boolean isPassable() {
		return true;
	}
	
	@Override
	public boolean isTraversable() {
		return true;
	}
}
