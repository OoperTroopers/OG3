package view.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ViewFrame extends JFrame {
	static View view;
	
	public ViewFrame() {
            
            view = View.getInstance();

            ViewFrame frame = this;

            frame.setSize(new Dimension(0, 0));
            frame.setTitle("FINAL BOSS 2.0");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            frame.setVisible(true);

            //this.setSize(600,800);
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
	
	public void initialize() {

            // ViewportStack.add(MainMenuViewport.getInstance());
            // ViewportStack.add(SimpleStatsViewport.getInstance());
            ViewportStack.add(ActiveGameViewport.getInstance());
            // ViewportStack.add(PauseMenuViewport.getInstance());
            addViewport(ViewportStack.top());
	}
}
