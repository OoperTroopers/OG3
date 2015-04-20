package model.statistics;

import view.view.ActiveGameViewport;

public class PrimaryStatistics {
	private int strength;
	private int hardiness;
	private int agility;
	private int intellect;
	private int livesLeft;
	private int movement;
	
	//generic constructor
	public PrimaryStatistics() {
		this.strength = 5;
		this.hardiness = 5;
		this.agility = 5;
		this.intellect = 5;
		this.livesLeft = 1;
		this.movement = 3;
	}
	
	//custom stats for NPC constructor
	public PrimaryStatistics(int s, int h, int a, int i, int m) {
		this.strength = s;
		this.hardiness = h;
		this.agility = a;
		this.intellect = i;
		this.livesLeft = 1;
		this.movement = m;
	}
	
	//custom stats for Avatar constructor
	public PrimaryStatistics(int s, int h, int a, int i, int ll, int m) {
		this.strength = s;
		this.hardiness = h;
		this.agility = a;
		this.intellect = i;
		this.livesLeft = ll;
		this.movement = m;
	}
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
		notifyGameView();
	}
	public int getHardiness() {
		return hardiness;
	}
	public void setHardiness(int hardiness) {
		this.hardiness = hardiness;
		notifyGameView();
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
		notifyGameView();
	}
	public int getIntellect() {
		return intellect;
	}
	public void setIntellect(int intellect) {
		this.intellect = intellect;
		notifyGameView();
	}
	public int getLivesLeft() {
		return livesLeft;
	}
	public void setLivesLeft(int livesLeft) {
		this.livesLeft = livesLeft;
		notifyGameView();
	}
	public int getMovement() {
		return movement;
	}
	public void setMovement(int movement) {
		this.movement = movement;
		notifyGameView();
	}
	
	public void loseLife() {
		--livesLeft;
		notifyGameView();
	}
	
	public void gainNewLife() {
		++livesLeft;
		notifyGameView();
	}
	
	public void increaseStrength(int increase ) {
		strength += increase;
		notifyGameView();
	}
	public void increaseHardiness(int increase ) {
		hardiness += increase;
		notifyGameView();
	}
	public void increaseAgility(int increase ) {
		agility += increase;
		notifyGameView();
	}
	public void increaseIntellect(int increase ) {
		intellect += increase;
		notifyGameView();
	}
	
	public String toString() {
		return	"Strength: "+strength+
				"\nHardiness: "+hardiness+
				"\nAgility: "+agility+
				"\nIntellect: "+intellect+
				"\nLivesLeft: "+livesLeft+
				"\nMovement: "+movement;
	}
	public void notifyGameView() {
		ActiveGameViewport.getInstance().updatePrimaries(this);
	}
}
