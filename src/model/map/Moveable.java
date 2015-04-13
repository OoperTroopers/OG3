/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

/**
 * Any object that can move itself will implement moveable. Each Moveable object
 * must handle movement itself, since movement permissions are different for each 
 * type of object. This is OOPier than a movementCoordinator.
 * @author Jason Owens
 */
public interface Moveable {
    public void moveNorth();
    public void moveSouth();
    public void moveNorthwest();
    public void moveNortheast();
    public void moveSoutheast();
    public void moveSouthwest();
}
