/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.statistics.Statistics;
import view.view.ExtendedStatsViewport;

/**
 *
 * @author Doherty
 */
public class StatsController {
    
    private Statistics stats;
    
    public StatsController(Statistics stats) {
        this.stats = stats;
    }
    
    public void updateView() {
       ExtendedStatsViewport.updateStatistics(stats);
    }
}
