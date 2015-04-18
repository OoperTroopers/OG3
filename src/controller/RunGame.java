package controller;


import model.abilities.movement.*;

import model.entities.Avatar;

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
        avatar.addAbility(new MoveNorthAbility(avatar, 'w'));
        avatar.addAbility(new MoveNorthwestAbility(avatar, 'q'));
        avatar.addAbility(new MoveNortheastAbility(avatar, 'e'));
        avatar.addAbility(new MoveSouthAbility(avatar, 's'));
        avatar.addAbility(new MoveSouthwestAbility(avatar, 'a'));
        avatar.addAbility(new MoveSoutheastAbility(avatar, 'd'));
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
