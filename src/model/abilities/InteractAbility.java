package model.abilities;

import java.util.List;

import controller.ControllerAvatar;
import controller.KeyBinding;
import model.entities.Avatar;
import model.entities.Entity;
import model.map.Tile;
import model.map.Tileable;

public class InteractAbility extends ExplicitAbility {
	Avatar avatar;
    private KeyBinding keyBinding;

	public InteractAbility() {
		super();
	}
	
	public InteractAbility(char keyToBind) {
		super();
		setName("Interact Ability");
		keyBinding = new KeyBinding(keyToBind, this);
		System.out.println("Interact Ability initialized");
	}
	
	public InteractAbility(Avatar avatar, char keyToBind) {
		super();
		setName("Interact Ability");
		keyBinding = new KeyBinding(keyToBind, this);
		this.avatar = avatar;
		System.out.println("Interact Ability initialized");

	}
	
	 @Override
	 public void perform() {
		 System.out.println("Interact ability called");
		 
		 boolean mounted = avatar.mounted() ? true : false;
		 
		 Tile tile = avatar.getTile();
		 List<Tileable> tileables = tile.getTileables();
		 for (Tileable t : tileables) {
			 if (avatar == t) continue;
			 t.acceptAvatarInteraction(avatar);
		 }
		 
		 if (mounted) avatar.removeMount();
	} 
	 
	@Override
	public void attachToController(ControllerAvatar controlAvatar) {
	     controlAvatar.addToKLSet(keyBinding);
	}
}
