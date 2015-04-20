/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.statistics.Statistics;
import view.view.ExtendedStatsViewport;
import view.view.Viewport;

/**
 *
 * @author Doherty
 */
public class StatsController extends Controller {
    
    private Statistics stats;
    private Viewport view;
    
    public StatsController(Statistics stats) {
        this.stats = stats;
        this.view = new ExtendedStatsViewport(new BackListener(), stats);
    }

    @Override
    public Viewport getViewport() {
        return view;
    }
    
    public class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller previous = GameController.getInstance().removeFromStack();
            GameController.getInstance().swapViews(previous);
        }    
    }
}
