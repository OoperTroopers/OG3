package controller;

import model.abilities.Ability;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Adam on 4/13/2015.
 */
public class KeyBinding implements KeyListener {
    private char key;
    private Ability ability;

    public KeyBinding(char key, Ability ability){
        this.key = Character.toUpperCase(key);
        this.ability = ability;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(key == Character.toUpperCase(e.getKeyChar())) {
            ability.perform();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}