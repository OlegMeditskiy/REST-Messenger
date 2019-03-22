package DAO;

import entities.Dialog;
import entities.Message;
import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDAO {

    @PersistenceContext(name = "MessagePU")
    EntityManager em;

    public Users find(Object id) {
        return em.find(Users.class, id);
    }

    public List<Dialog> listAllDialogs(Users u) {
        return u.getDialog();
    }

    public List<Message> listAllMessages(Users u) {
        return u.getMessage();
    }

}
