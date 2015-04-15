
import model.entities.*;
import model.items.*;

public class ItemsTest {
	
	public static void main(String[] args) {
		
		Entity entity = new Avatar();
		System.out.println("Health: " + entity.getStats().getCurrentHealth());
		entity.receiveDamage(5);
		System.out.println("Health: " + entity.getStats().getCurrentHealth());
		Item item = new HealingOneShotItem();
		item.touch(entity);
		System.out.println("Health: " + entity.getStats().getCurrentHealth());
	
	}
	
}
