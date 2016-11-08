/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.Tweet;

import java.util.ArrayList;

/**
 *
 * @author Timothy
 */
public class NewsFeed implements Observer
{
    ArrayList<String> feed;
    
    public NewsFeed()
    {
        feed = new ArrayList<String>();
    }

    @Override
    public void update(String msg, Subject sub) 
    {
        User u = (User)sub;
        feed.add(u.getID()+ ": " + msg);
        
    }
    
    public ArrayList<String> getFeed()
    {
        return feed;
    }

    
}
