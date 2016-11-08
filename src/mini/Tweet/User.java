package mini.Tweet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class User extends UserManager implements Subject
{
    private String group; //Can only belong to one.
    private static HashMap<String, User> users = new HashMap<String, User>();
    private ArrayList<Observer> followers;
    private ArrayList<String> following;
    private ArrayList<String> tweets;
    private NewsFeed nf;
    
    public User(String id, String group)
    {
        if(!users.containsKey(id))
        {
            this.id = id;
            followers = new ArrayList<Observer>();
            following = new ArrayList<String>();
            tweets = new ArrayList<String>();
            this.group = group;
            nf = new NewsFeed();
            this.register(nf);
            users.put(id, this);
        }
        else
        {
            System.out.println("ID already exists!"); //Filler, will have dialog pop up instead
        }
    }
    
    public NewsFeed getFeed()
    {
        return nf;
    }
    
    public static boolean exists(String uid)
    {
        return users.containsKey(uid);
    }
    
    public void follow(String id)
    {
        users.get(id).register(nf);
        following.add(id);
        for(String s : users.get(id).getTweets())
        {
            nf.update(s, users.get(id));
        }
    }
    
    public void joinGroup(String id)
    {
        group = id;
    }
    
    public String getGroup()
    {
        return group;
    }
    public ArrayList<String> getTweets()
    {
        return tweets;
    }
    public void tweet(String msg)
    {
        tweets.add(msg);
        notifyObs();
    }

    @Override
    public void register(Observer obj) 
    {
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
    public void notifyObs()
    {
        for(Observer obs : followers)
        {
            obs.update(tweets.get(tweets.size()-1), this);
        }
    }
    public boolean isFollowing(String id)
    {
        return following.contains(id);
    }
    @Override
    public Object getUpdate(Observer obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(UserManager um) {
        System.out.println("Can't add to leaf.");
    }

    @Override
    public ArrayList<UserManager> getMembers() {
        return null;
    }
    
    public ArrayList<String> getFollowing()
    {
        return following;
    }

    public Collection getUsers()
    {
        return users.values();
    }
    
    @Override
    public void accept(InfoVisitor v) 
    {
        v.visit(this);
    }
}
