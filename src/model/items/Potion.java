package model.items;

import model.statistics.Statistics;

public class Potion extends TakeableItem implements Usable{
	public void use(Statistics stats){
		stats.fullRestore();
	}
}
