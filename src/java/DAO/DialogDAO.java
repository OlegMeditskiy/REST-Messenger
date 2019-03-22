/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Message;
import entities.Dialog;
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
public class DialogDAO {

    @PersistenceContext(name = "MessagePU")
    EntityManager em;

    public Dialog find(Object id) {
        return em.find(Dialog.class, id);
    }

    public List <Message> listAllMessages(Dialog d) {
       return d.getMessages();
    }
    
    public List <Users> listAllUsers(Dialog d) {
       return d.getUser();
    }
    
    public List<Dialog> listAllDialogs() {
        return em.createQuery("SELECT d FROM Dialog d").getResultList();
    }

}
