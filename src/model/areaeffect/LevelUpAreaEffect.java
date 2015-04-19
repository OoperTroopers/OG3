package model.areaeffect;

import model.effects.Effect;
import model.effects.LevelUpEffect;
import model.map.Tile;
import view.modelview.areaeffect.LevelUpAreaEffectView;
import view.modelview.tile.TileView;

public class LevelUpAreaEffect extends AreaEffect {
	private static LevelUpAreaEffectView levelUpAreaEffectView = new LevelUpAreaEffectView();
	private Effect effect;

	public LevelUpAreaEffect() {
		super(levelUpAreaEffectView);
		this.effect = new LevelUpEffect();
	}

	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);
	}

	@Override
	public boolean isTraversable() {
		return true;
	}

	@Override
	public void removeFromView(TileView tileView) {
		
	}

}
