package view.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import controller.MainMenuController;

import view.tools.Constants;
import view.tools.ImagePaths;
import view.tools.Text;


@SuppressWarnings("serial")
public class MainMenuViewport extends Viewport {
	
	private ActionListener newGameListener;
	private ActionListener loadGameListener;
	private ActionListener exitGameListener;
	
	//public static MainMenuViewport mainMenuViewport = new MainMenuViewport();
	
	public MainMenuViewport() {
		this.setPreferredSize(new Dimension(Constants.VIEW_WIDTH, Constants.VIEW_HEIGHT));
	}
	
	public MainMenuViewport(ActionListener newGameListener, ActionListener loadGameListener, ActionListener exitGameListener) {
		this.setPreferredSize(new Dimension(Constants.VIEW_WIDTH, Constants.VIEW_HEIGHT));
		this.newGameListener = newGameListener;
		this.loadGameListener = loadGameListener;
		this.exitGameListener = exitGameListener;
	}

	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
		
	}
	
	public MainMenuViewport getInstance() {
		return this;
	}
	
	@Override
	public void paint(Graphics g) {
		// black background
		g.setColor(Color.black);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		g.fillRect(0,0,dimension.width,dimension.height);
	
		// banner
		g.setFont( new Font("DialogInput", Font.BOLD, 35) );
		g.setColor(Color.WHITE);
		g.drawString(Text.mainMenuBanner, 80, 30);
		
		try { 
			Image image = ImageIO.read(new File(ImagePaths.MAGIC_CAT));
			g.drawImage(image, 130, 60, 300, 300, null);
		} 
		catch (IOException ie) {ie.printStackTrace();}
		
		JButton newGameButton = new JButton();
		newGameButton.addActionListener(this.newGameListener);
		newGameButton.setBounds(65, 390, 400, 50);
		newGameButton.setOpaque(false);
		this.add(newGameButton);
		
		JButton loadGameButton = new JButton();
		loadGameButton.addActionListener(this.loadGameListener);
		loadGameButton.setBounds(65, 460, 400, 50);
		loadGameButton.setOpaque(false);
		this.add(loadGameButton);
		
		JButton exitGameButton = new JButton();
		exitGameButton.addActionListener(this.exitGameListener);
		exitGameButton.setBounds(65, 530, 400, 50);
		exitGameButton.setOpaque(false);
		this.add(exitGameButton);

		g.setColor(Color.GREEN);
		g.fillRect(65, 390, 400, 50);	

		g.setColor(Color.YELLOW);
		g.fillRect(65, 460, 400, 50);

		g.setColor(Color.RED);
		g.fillRect(65, 530, 400, 50);		

		g.setColor(Color.BLACK);
		g.setFont( new Font("DialogInput", Font.BOLD, 20) );
		g.drawString(Text.newGameButton, 70, 420);
		g.drawString(Text.loadGameButton, 70, 490);
		g.drawString(Text.exitGameButton, 70, 560);
		
	}
	
}
