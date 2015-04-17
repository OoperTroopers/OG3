package view.tools;

import model.map.Location;

public class LocationPositionConverter {
	public static Location convert(ViewPosition viewPosition) {
		int newX = viewPosition.getX();
		int newY = viewPosition.getY();
		
		// int newX = Constants.MAP_X_ORIGIN + (x * Constants.TILE_WIDTH);
		// int newY = Constants.MAP_Y_ORIGIN + (y * Constants.TILE_HEIGHT);
		return new Location(newX,newY,newY);
	}
	
	public static ViewPosition convert(Location location) {
		int x = location.getX();
		int y = location.getY();
		
		int newX = Constants.MAP_X_ORIGIN + (x * Constants.TILE_WIDTH);
		int newY = Constants.MAP_Y_ORIGIN + (y * Constants.TILE_HEIGHT);
		return new ViewPosition(newX,newY);	
	}
			
}
