package model.effects;

import controller.GameTimer;

public abstract class TimedEffect extends Effect {
	GameTimer gameTimer;
	private int occurrences;
	
	public TimedEffect() {
		gameTimer = GameTimer.getInstance();
	}
	
	public TimedEffect(int occurrences) {
		gameTimer = GameTimer.getInstance();
		this.occurrences = occurrences;
	}
	
	public int getOccurrences() { 
		return occurrences;
	}
	
	public void setOccurrences(int occurrences) { 
		this.occurrences = occurrences; 
	}
}
