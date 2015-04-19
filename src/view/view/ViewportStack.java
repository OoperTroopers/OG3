package view.view;

public class ViewportStack {
	private static ViewportStack viewportStack = new ViewportStack();
	private MainMenuViewport mainMenuViewport;
	private ActiveGameViewport activeGameViewport;
	private HeartsViewport heartsViewport;
	private SimpleStatsViewport simpleStatsViewport;
	private PauseMenuViewport pauseMenuViewport;
	
	public ViewportStack() {
		
	}
	
	public void whichViewports() {
		if (mainMenuViewport != null)  		System.out.println("Main Menu Viewport");
		if (activeGameViewport != null)  	System.out.println("Active Game Viewport");
		if (heartsViewport != null)  		System.out.println("Hearts Viewport");
		if (simpleStatsViewport != null)  	System.out.println("Simple Stats Viewport");
		if (pauseMenuViewport != null)  	System.out.println("Pause Menu Viewport");
	}
	
	public static ViewportStack getInstance() {
		return viewportStack;
	}
		
	public void add(MainMenuViewport v) {		mainMenuViewport = v;		}
	public void add(ActiveGameViewport v) {		activeGameViewport = v;	}
	public void add(HeartsViewport v) {		heartsViewport = v;			}
	public void add(SimpleStatsViewport v) {	simpleStatsViewport = v;	}
	public void add(PauseMenuViewport v) {          pauseMenuViewport = v;			}
	
	public Viewport getMainMenuViewport() {		return mainMenuViewport;		}
	public Viewport getActiveGameViewport() {	return activeGameViewport;	}
	public Viewport getHeartsViewport() {		return heartsViewport;			}
	public Viewport getSimpleStatsViewport() {	return simpleStatsViewport;		}
	public Viewport getPauseMenuViewport() {	return pauseMenuViewport;			}	
	
	// the "pop"s return true if there was one originally
	public boolean popMainMenuViewport() {			
		if (mainMenuViewport != null) {
			mainMenuViewport = null; 
			return true;
		}	return false;
	}
	
	public boolean popActiveGameViewport() {
		if (activeGameViewport != null) {
			activeGameViewport = null; 
			return true;
		} 	return false;
	}
	
	public boolean popHeartsViewport() {
		if (heartsViewport != null) {
			heartsViewport = null; 
			return true;
		} 	return false;
	}
	
	public boolean popSimpleStatsViewport() {
		if (simpleStatsViewport != null) {
			simpleStatsViewport = null; 
			return true;
		} 	return false;
	}
	
	public boolean popPauseMenuViewport() {
		if (pauseMenuViewport != null) {
			pauseMenuViewport = null; 
			return true;
		} 	return false;
	}
}
