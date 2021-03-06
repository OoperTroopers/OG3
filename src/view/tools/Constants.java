package view.tools;

import java.awt.Dimension;

public class Constants {
	// ---------------
	// views + viewports
	public static final int VIEW_HEIGHT = 600;
	public static final int VIEW_WIDTH = 800;
		
	public static final int GAME_VIEW_HEIGHT = 800;
	public static final int GAME_VIEW_WIDTH = 600;

	public static final int HEART_VIEW_WIDTH = 200;
	public static final int HEART_VIEW_HEIGHT = 100;

	// ---------------
	// tiles
	public static final double TILE_SIZE = 26.1;
	public static final int TILE_WIDTH = 50;
	public static final int TILE_HEIGHT = 50;
	public static final int MINI_TILE_HEIGHT = 5;
	public static final int MINI_TILE_WIDTH = 5;
	public static final int MAP_X_ORIGIN = 10;
	public static final int MAP_Y_ORIGIN = 10;

	
	
	// malleable values
	private static int SCREEN_WIDTH;
	private static int SCREEN_HEIGHT;
	
	public static int getScreenWidth() { return SCREEN_WIDTH; }
	public static int getScreenHeight() { return SCREEN_HEIGHT; }
	
	public static void setScreenDimensions(Dimension size) {
		SCREEN_WIDTH = (int)size.getWidth();
		SCREEN_HEIGHT = (int)size.getHeight();
	}
	
}
