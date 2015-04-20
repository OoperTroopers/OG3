package model.effects;

import model.entities.Entity;
import model.entities.Mount;
import model.entities.NPC;

public class DamageEffect extends Effect {
	private int damage;
	
	public DamageEffect(){
		this.damage = 10;
	}
	
	public DamageEffect(int damage) {
		this.damage = damage;
	}
	
	public void visit(Entity entity) {
		entity.receiveDamage(damage);
	}
	
	public void visit(Mount mount) {
		mount.receiveDamage(damage);
	}
	
	public void visit(NPC npc) {
		npc.receiveDamage(damage);
	}
	
}