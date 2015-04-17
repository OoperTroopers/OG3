package view.view;

public class PauseMenuViewport extends Viewport {
	public static Viewport pauseMenuViewport = new PauseMenuViewport();
	
	public PauseMenuViewport() {}

	@Override
	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
}
