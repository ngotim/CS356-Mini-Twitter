/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.Tweet;

/**
 *
 * @author Timothy
 */
public interface Subject 
{
    public void register(Observer obj);
    
    public void notifyObs();
    
    public Object getUpdate(Observer obj);
}
