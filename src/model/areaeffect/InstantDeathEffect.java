package model.areaeffect;

import model.effects.Effect;
import model.map.Tile;
import view.modelview.areaeffect.InstantDeathEffectView;

public class InstantDeathEffect extends AreaEffect{

	private static InstantDeathEffectView instantDeathEffectView = new InstantDeathEffectView();

	public InstantDeathEffect() {
		super(instantDeathEffectView);
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
