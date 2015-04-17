package view.view;

public class PauseMenuViewport extends Viewport {
	public PauseMenuViewport() {}

	@Override
	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
}
