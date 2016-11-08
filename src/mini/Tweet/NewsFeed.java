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
public class NewsFeed implements Observer, Subject
{
    ArrayList<String> feed;
    ArrayList<Observer> followers;
    
    public NewsFeed()
    {
        feed = new ArrayList<String>();
        followers = new ArrayList<Observer>();
    }

    @Override
    public void update(String msg, Subject sub) 
    {
        User u = (User)sub;
        feed.add(u.getID()+ ": " + msg);
        notifyObs();
    }
    
    public ArrayList<String> getFeed()
    {
        return feed;
    }

    @Override
    public void register(Observer obj) {
        if(obj == null)
        {
            System.out.println("Null observer");
        }
        if(!followers.contains(obj))
        {
            followers.add(obj);
        }
    }

    @Override
    public void notifyObs() {
        for(Observer ob : followers)
        {
            ob.update(null, this);
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
