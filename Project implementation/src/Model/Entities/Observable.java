/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entities;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface Observable {
    public void getObservers();
    public void notifyUpdate();
}
