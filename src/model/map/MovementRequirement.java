/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

/**
 * Contains movement requirements of an object
 * @author Jason Owens
 */
public class MovementRequirement {
    private boolean requireWaterWalking;
    private boolean requireGrassWalking;
    private boolean requireMountainWalking;
    
    
    public MovementRequirement(){
        requireGrassWalking=false;
        requireWaterWalking=true;        
        requireMountainWalking=true;
    }
    public MovementRequirement(boolean grass, boolean water, boolean mountain){
        requireGrassWalking=grass;
        requireWaterWalking=water;        
        requireMountainWalking=mountain;
    }
    
    public boolean requireWaterWalking(){
        return requireWaterWalking; 
    }
    public boolean requireMountainWalking(){
        return requireMountainWalking;
    }
    public boolean requireGrassWalking(){
        return requireGrassWalking;
    }
}
