package model.areaeffect;

import model.effects.Effect;
import model.map.Tile;
import view.modelview.areaeffect.LevelUpAreaEffectView;
import view.modelview.tile.TileView;

public class LevelUpAreaEffect extends AreaEffect {

	private static LevelUpAreaEffectView levelUpAreaEffectView = new LevelUpAreaEffectView();

	public LevelUpAreaEffect() {
		super(levelUpAreaEffectView);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acceptEffect(Effect e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTraversable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeFromView(TileView tileView) {
		
	}

}
