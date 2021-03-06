import model.loadsave.*;
import model.entities.*;
import model.items.*;
import model.inventory.*;
import model.map.Tile;
import model.loadsave.Load;
import model.statistics.EquippableStatistics;

public class ShopTest {
	public static void main(String[] args) {
		Load lo = new Load();
		try{
		lo.read(FilePaths.DEFAULT);}
		catch(Exception e) {}
		Tile bTile = lo.getBeginningTile();
		Shopkeeper shopkeep = new Shopkeeper(bTile);
		Avatar avatar = new Avatar(bTile);
		avatar.setGold(100);
		Helmet helm = new Helmet("Helm", "helm", "1234", 20, new EquippableStatistics());
		Arms arm = new Arms("Helm", "helm", "1234", 10, new EquippableStatistics());
		avatar.addItemToInventory(helm);
		shopkeep.addItemToInventory(arm);
		
		System.out.println("Avatar start gold: " + avatar.getCurrentGold());
		
		Shop shop = new Shop(avatar.getInventory(), shopkeep.getInventory(),avatar.getBargainingAbilityLevel(), avatar.getCurrentGold());
		
		System.out.println("Helmet price: " + helm.getValue());
		System.out.println("Adjusted Sell price: " + shop.adjustedSellPrice(helm));
		
		System.out.println("Arms price: " + arm.getValue());
		System.out.println("Adjusted Buy price: " + shop.adjustedBuyPrice(arm));
		
		shop.buyItem(arm);
		shop.sellItem(helm);
		
		avatar.setGold(shop.openShop());
		System.out.println("Avatar end gold: " + avatar.getCurrentGold());
	}
}
