package model.statistics;

public class PrimaryStatistics {
	private int strength;
	private int hardiness;
	private int agility;
	private int intellect;
	private int livesLeft;
	
	//generic constructor
	public PrimaryStatistics() {
		this.strength = 5;
		this.hardiness = 5;
		this.agility = 5;
		this.intellect = 5;
		this.livesLeft = 1;
	}
	
	//custom stats for NPC constructor
	public PrimaryStatistics(int s, int h, int a, int i) {
		this.strength = s;
		this.hardiness = h;
		this.agility = a;
		this.intellect = i;
		this.livesLeft = 1;
	}
	
	//custom stats for Avatar constructor
	public PrimaryStatistics(int s, int h, int a, int i, int ll) {
		this.strength = s;
		this.hardiness = h;
		this.agility = a;
		this.intellect = i;
		this.livesLeft = ll;
	}
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getHardiness() {
		return hardiness;
	}
	public void setHardiness(int hardiness) {
		this.hardiness = hardiness;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getIntellect() {
		return intellect;
	}
	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}
	public int getLivesLeft() {
		return livesLeft;
	}
	public void setLivesLeft(int livesLeft) {
		this.livesLeft = livesLeft;
	}
	
	public void loseLife() {
		--livesLeft;
	}
	
	public void gainNewLife() {
		++livesLeft;
	}
}
