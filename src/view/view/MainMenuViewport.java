package view.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.border.Border;

import view.tools.Constants;
import view.tools.ImagePaths;
import view.tools.Text;


@SuppressWarnings("serial")
public class MainMenuViewport extends Viewport {
	public static MainMenuViewport mainMenuViewport = new MainMenuViewport();
	
	public MainMenuViewport() {
		this.setPreferredSize(new Dimension(Constants.VIEW_WIDTH, Constants.VIEW_HEIGHT));
	}

	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
		
	}
	
	public static MainMenuViewport getInstance() {
		return mainMenuViewport;
	}
	
	@Override
	public void paint(Graphics g) {
		// black background
		g.setColor(Color.black);
		g.fillRect(0,0,Constants.VIEW_WIDTH,Constants.VIEW_HEIGHT);
		
		// banner
		// g.setColor(Color.GREEN);
		// g.fillRect(100, 50, 400, 70);
		
		g.setFont( new Font("DialogInput", Font.BOLD, 35) );
		g.setColor(Color.WHITE);
		g.drawString(Text.mainMenuBanner, 80, 30);
		
		try { 
			Image image = ImageIO.read(new File(ImagePaths.MAGIC_CAT));
			g.drawImage(image, 130, 60, 300, 300, null);
		} 
		catch (IOException ie) {ie.printStackTrace();}
		

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
		g.drawString(Text.ExitGameButton, 70, 560);
	}
	
}
