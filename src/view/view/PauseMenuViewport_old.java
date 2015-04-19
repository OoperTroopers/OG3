package view.view;

public class PauseMenuViewport_old extends Viewport {
	public static Viewport pauseMenuViewport = new PauseMenuViewport_old();
	
	public PauseMenuViewport_old() {}

	@Override
	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
}
