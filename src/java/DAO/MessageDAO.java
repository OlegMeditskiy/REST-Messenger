/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Dialog;
import entities.Message;

import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author olegm
 */
@Stateless
public class MessageDAO {
    @PersistenceContext(name = "MessagePU")
    EntityManager em;
    
    public void addMessageFromUser(Message m,Dialog d, Users u){
        m.setMessage("Message from "+u.getFirstName()+" "+u.getLastName()+": '"+m+"'");
        d.addMessage(m);
        d.addUser(u);
        u.addDialog(d);
        u.addMessage(m);
        em.persist(m);
        em.merge(u);
        em.merge(d);

    }
    
    public Message find(Object id) {
        return em.find(Message.class, id);
    }
    
}
