package view.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import view.tools.Constants;

public class ViewFrame extends JFrame {
	static View view;
	
	static ViewFrame viewFrame = new ViewFrame();
	public ViewFrame() {
            
            view = View.getInstance();

            ViewFrame frame = this;

            frame.setSize(new Dimension(0, 0));
            frame.setTitle("FINAL BOSS 2.0");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            frame.setVisible(true);
            Constants.setScreenDimensions(this.getSize());
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);

            view.stylize();

            this.add(view);

	}
        
        public void refresh() {
            this.remove(0);
            this.add(view);
        }
	
	public void addViewport(Viewport v) {
            view.addViewport(v);
	}
	
	public void addViewport(Viewport v, String BorderLayout) {
		view.addViewport(v, BorderLayout);
	}
	
	public static ViewFrame getInstance() { return viewFrame; }
	public void initialize() {

            // ViewportStack.add(MainMenuViewport.getInstance());
            // ViewportStack.add(SimpleStatsViewport.getInstance());
            ViewportStack.add(ActiveGameViewport.getInstance());
            // ViewportStack.add(ExtendedStatsViewport.getInstance());
            // ViewportStack.add(PauseMenuViewport.getInstance());
            addViewport(ViewportStack.top(), BorderLayout.CENTER);
	}
	
	public int getWidth() { return (int)this.getSize().getWidth(); }
	public int getHeight() { return (int)this.getSize().getHeight(); }
}
