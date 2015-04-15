
import model.entities.*;
import model.items.*;

public class ItemsTest {
	
	public static void main(String[] args) {
		
		Entity entity = new Avatar();
		System.out.println("Health: " + entity.getStats().getCurrentHealth());
		System.out.println("Max health: " + entity.getStats().getDerivedStats().getMaxHealth());
		entity.receiveDamage(18);
		System.out.println("Health: " + entity.getStats().getCurrentHealth());
		System.out.println("Max health: " + entity.getStats().getDerivedStats().getMaxHealth());
		Item item = new HealingOneShotItem();
		item.touch(entity);
		System.out.println("Health: " + entity.getStats().getCurrentHealth());
		System.out.println("Max health: " + entity.getStats().getDerivedStats().getMaxHealth());
	
	}
	
}
