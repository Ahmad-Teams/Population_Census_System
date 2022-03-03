/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.implementation;

/**
 *
 * @author PC
 */
public interface Observable {
    public Observer getObservers();
    public void notifyUpdate();
}
