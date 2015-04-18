package model.areaeffect;

import model.effects.Effect;
import view.modelview.areaeffect.TakeDamageEffectView;

public class TakeDamageEffect extends AreaEffect {

	private static TakeDamageEffectView takeDamageEffectView = new TakeDamageEffectView();
	
	public TakeDamageEffect() {
		super(takeDamageEffectView);
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

}
