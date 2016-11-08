/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.Tweet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Timothy
 */
public class UserGroup extends UserManager
{
    private ArrayList<UserManager> members;
    public static HashMap<String, UserGroup> groups = new HashMap<String, UserGroup>();
    
    public UserGroup(String id)
    {
        members = new ArrayList<UserManager>();
        this.id = id;
        groups.put(id, this);
    }

    @Override
    public void add(UserManager um) 
    {
        if(um.getMembers() == null)
            members.add((User)um);
        else
            members.add((UserGroup)um);
    }
    public ArrayList<UserManager> getMembers()
    {
        return members;
    }
    
    public static boolean exists(String uid)
    {
        return groups.containsKey(uid);
    }
    
    public static UserGroup findGroup(String s)
    {
        return groups.get(s);
    }
}
