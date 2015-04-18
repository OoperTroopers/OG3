
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
		
		Item healItem = new HealingOneShotItem();
		healItem.touch(entity);
		System.out.println("Health: " + entity.getStats().getCurrentHealth());
		System.out.println("Max health: " + entity.getStats().getDerivedStats().getMaxHealth());
		
		Item damageItem = new DamagingOneShotItem();
		damageItem.touch(entity);
		System.out.println("Health: " + entity.getStats().getCurrentHealth());
		System.out.println("Max health: " + entity.getStats().getDerivedStats().getMaxHealth());
		
		Potion potion = new Potion();
		entity.addItemToInventory(potion);
		System.out.println(entity.getInventory().itemInInventory(potion));
		potion.use(entity);
		System.out.println("Health: " + entity.getStats().getCurrentHealth());
		System.out.println(entity.getInventory().itemInInventory(potion));
	}
	
}
