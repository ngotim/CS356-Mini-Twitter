/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.Tweet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Timothy
 */
public class PositiveVisitor implements InfoVisitor
{
    @Override
    public void visit(User u) {
        File pos = new File("C:\\Users\\Timothy\\Documents\\NetBeansProjects\\Mini Twit\\src\\mini\\Tweet\\PositiveWords");
        double total = 0;
        double posTot = 0;
        ArrayList<String> words = new ArrayList<String>();
        
        try {
            Scanner sc = new Scanner(pos);
            while(sc.hasNextLine())
            {
                words.add(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PositiveVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Object o : u.getUsers())
        {
            User us = (User) o;
            for(String s : us.getTweets())
            {
                for(String word : words)
                {
                    if(s.toLowerCase().contains(word))
                        posTot++;
                }
                total += s.split(" ").length;
            }
        }
        JOptionPane.showMessageDialog(null, "Total positive words: " + posTot/total);
    }

    @Override
    public void visit(UserGroup ug) {
        
    }
    
}
