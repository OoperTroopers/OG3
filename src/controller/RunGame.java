package controller;

import model.abilities.AttackAbility;
import model.abilities.SneakAbility;
import model.entities.Avatar;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class RunGame extends JPanel {
    public RunGame(){
        Avatar avatar = new Avatar();
        avatar.addAbility(new SneakAbility(avatar, 's'));
        avatar.addAbility(new AttackAbility(avatar, 'a'));
        addAvatarKeyBinding(avatar.getKeyBinding());
        setFocusable(true);
    }
    public static void main(String args[]){
        JFrame frame = new JFrame("Controller Example");
        RunGame runGame = new RunGame();
        frame.add(runGame);
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
