package model.areaeffect;

import model.effects.Effect;
import model.map.Tile;
import view.modelview.areaeffect.LevelUpEffectView;

public class LevelUpEffect extends AreaEffect {

	private static LevelUpEffectView levelUpEffectView = new LevelUpEffectView();

	public LevelUpEffect() {
		super(levelUpEffectView);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acceptEffect(Effect e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromTile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tile getContainingTile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTraversable() {
		// TODO Auto-generated method stub
		return false;
	}

}
