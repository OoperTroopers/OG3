/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.view.PauseMenuViewport;
import view.view.Viewport;

/**
 *
 * @author Doherty
 */
public class PauseMenuController extends Controller {
    
    private Viewport view;
    
    public PauseMenuController() {
        view = new PauseMenuViewport(new BackListener());
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
            
        }    
    }
    
    private class SaveGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }    
    }
    

    @Override
    public Viewport getViewport() {
        return view;
    }
    
}