package mini.Tweet;

import java.util.ArrayList;
import java.util.HashMap;

public class User extends UserManager implements Subject
{
    private String group; //Can only belong to one.
    private static HashMap<String, User> users = new HashMap<String, User>();
    private ArrayList<NewsFeed> followers;
    private ArrayList<String> following;
    private ArrayList<String> tweets;
    private NewsFeed nf;
    
    public User(String id, String group)
    {
        if(!users.containsKey(id))
        {
            this.id = id;
            followers = new ArrayList<NewsFeed>();
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
    }
    
    public void joinGroup(String id)
    {
        group = id;
    }
    
    public String getGroup()
    {
        return group;
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
        if(!followers.contains((NewsFeed)obj))
        {
            followers.add((NewsFeed) obj);
        }
    }

    @Override
    public void notifyObs()
    {
        for(NewsFeed nf : followers)
        {
            nf.update(tweets.get(tweets.size()-1), this);
        }
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
}
