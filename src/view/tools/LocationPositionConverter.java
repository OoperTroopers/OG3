package view.tools;

import model.map.Location;

public class LocationPositionConverter {
	public static Location convert(ViewPosition viewPosition) {
		return new Location(0,0,0);
	}
	
	public static ViewPosition convert(Location location) {
		return new ViewPosition(0,0);
	}
			
}
