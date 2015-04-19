import model.statistics.*;

public class StatisticsTest {
	public static void main(String[] args) {
		SmasherStatistics smashStats = new SmasherStatistics();
		System.out.println("level: " + smashStats.getCurrentLevel());
		System.out.println("strength: " + smashStats.getPrimaryStats().getStrength());
		System.out.println("intellect: " + smashStats.getPrimaryStats().getIntellect());
		System.out.println("offensive: " + smashStats.getOffensiveRating());
		System.out.println("defensive: " + smashStats.getDefensiveRating());
		smashStats.increaseExperience(100);
		System.out.println("level: " + smashStats.getCurrentLevel());
		System.out.println("strength: " + smashStats.getPrimaryStats().getStrength());
		System.out.println("intellect: " + smashStats.getPrimaryStats().getIntellect());
		System.out.println("offensive: " + smashStats.getOffensiveRating());
		System.out.println("defensive: " + smashStats.getDefensiveRating());
		smashStats.increaseExperience(110);
		System.out.println("level: " + smashStats.getCurrentLevel());
		System.out.println("strength: " + smashStats.getPrimaryStats().getStrength());
		System.out.println("intellect: " + smashStats.getPrimaryStats().getIntellect());
		System.out.println("offensive: " + smashStats.getOffensiveRating());
		System.out.println("defensive: " + smashStats.getDefensiveRating());
	}
}
