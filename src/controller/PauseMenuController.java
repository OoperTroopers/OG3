/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.entities.Avatar;
import view.view.PauseMenuViewport;
import view.view.Viewport;

/**
 *
 * @author Doherty
 */
public class PauseMenuController extends Controller {
    
    private Viewport view;
    private Avatar avatar;
    
    public PauseMenuController(Avatar avatar) {
        view = new PauseMenuViewport(new BackListener(), new InventoryListener(), new StatsListener(), new ExitGameListener());
        this.avatar = avatar;
    }
    
    private class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           Controller previousController = GameController.getInstance().removeFromStack();
           GameController.getInstance().swapViews(previousController);
        }     
    }
    
    private class StatsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GameController.getInstance().addToStack(GameController.getInstance().getActiveController());
            GameController.getInstance().swapViews(new StatsController(avatar.getStats()));
        }    
    }
    
    private class SaveGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }    
    }
    
    private class InventoryListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GameController.getInstance().addToStack(GameController.getInstance().getActiveController());
            GameController.getInstance().swapViews(new InventoryController(avatar));
        }       
    }
    
    private class ExitGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GameController.getInstance().swapViews(new MainMenuController());
        }
        
    }
    

    @Override
    public Viewport getViewport() {
        return view;
    }
    
}