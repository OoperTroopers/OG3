/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.view.Viewport;
import view.view.ViewportStack;

/**
 *
 * @author Doherty
 */
public class ScreenNavigation {
    
    public static void backButtonHandler() {
        ViewportStack.pop();
        Viewport newTop = ViewportStack.top();
        newTop.repaint();
    }
    
    public static void genericButtonHandler(Viewport v) {
        ViewportStack.add(v);
        v.repaint();
    }
    
    public static void exitToMainMenuButtonHandler() {
        while (ViewportStack.size() > 1) {
            ViewportStack.pop();
        }
    }
}
