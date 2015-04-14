package model.effects;

/**
 * Effect represents an effect that an object can have on Tileable objects. Effect utilizes
 * the visitor pattern by defining all of the possible Tileable objects an Effect can visit,
 * and when a specific effect wants to have an effect on an object, it will override that
 * specific visit method.
 * @author Cormac McCarthy
 */

import model.map.*;
import model.entities.*;
import model.items.*;

public abstract class Effect {
	
	public void visit(Tileable tileable){ }
	public void visit(Entity entity) { }
	public void visit(Avatar avatar) { }
	public void visit(NPC npc) { }
	public void visit(Item item) { }
	public void visit(Trap trap) { }
	public void visit(AreaEffect areaEffect) { }
		
}
