package view.view;


public class MainMenuViewport extends Viewport {
	public MainMenuViewport() {}

	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
		
	}
	
}
