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
public interface InfoVisitor {
    public void visit(User u);
    public void visit(UserGroup ug);
}
