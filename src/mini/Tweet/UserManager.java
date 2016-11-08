/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.Tweet;

import java.util.ArrayList;
import javax.swing.tree.TreeModel;

/**
 *
 * @author Timothy
 */
public abstract class UserManager
{
    protected String id;
    
    public abstract void add(UserManager um);
    
    public String getID()
    {
        return id;
    }
    @Override
    public String toString() {
        return id;
    }
    public abstract ArrayList<UserManager> getMembers();
    public abstract void accept(InfoVisitor v);
}
