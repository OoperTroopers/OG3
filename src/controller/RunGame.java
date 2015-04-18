package controller;

import model.entities.Avatar;
import model.entities.Entity;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class RunGame extends JPanel {
	
    public RunGame(){
        Avatar avatar = new Avatar();
        addAvatarKeyBinding(avatar.getKeyBinding());
        setFocusable(true);
    }
    
    public RunGame(Avatar avatar){
        avatar.addAbility(new SneakAbility(avatar, 's'));
        avatar.addAbility(new AttackAbility(avatar, 'a'));
        addAvatarKeyBinding(avatar.getKeyBinding());
        setFocusable(true);
        start();
    }
    
    public static void main(String args[]){
        
    }
    
    public void start() {
    	JFrame frame = new JFrame("Controller Example");
        frame.add(this);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addAvatarKeyBinding(ArrayList<KeyListener> kbList){
        for(int i = 0; i < kbList.size(); i++){
            addKeyListener(kbList.get(i));
        }
    }
}
