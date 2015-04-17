package controller;

import model.entities.Avatar;

import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Adam on 4/13/2015.
 */
public class ControllerAvatar {
    private Avatar avatar;
    private ArrayList<KeyListener> kbList;

    public ControllerAvatar(Avatar avatar){
        this.avatar = avatar;
        kbList = new ArrayList<KeyListener>();
    }

    public void addToKLSet(KeyBinding keyBinding){
        kbList.add(keyBinding);
    }

    public ArrayList<KeyListener> getKbList(){
        return kbList;
    }
}
