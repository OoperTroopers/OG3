package view.view;

import javax.swing.JFrame;

public class ViewFrame extends JFrame {
	public ViewFrame() {
		this.setSize(600,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.add(View.getInstance());

	}
}
