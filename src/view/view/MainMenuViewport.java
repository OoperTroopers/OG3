package view.view;


public class MainMenuViewport extends Viewport {
	public static Viewport mainMenuViewport = new MainMenuViewport();
	
	public MainMenuViewport() {}

	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
		
	}
	
}
