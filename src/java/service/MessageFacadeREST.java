/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.DialogDAO;
import DAO.MessageDAO;
import DAO.UserDAO;
import entities.Message;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author olegm
 */
@Stateless
@Path("message")
public class MessageFacadeREST extends AbstractFacade<Message> {

    @PersistenceContext(unitName = "MessagePU")
    private EntityManager em;

    public MessageFacadeREST() {
        super(Message.class);
    }
    
    @Inject
    MessageDAO message;
    
    @Inject
    UserDAO users;
    
    @Inject
    DialogDAO dialog;
    

    @POST
    @Path("dialog/{id}/user/{id2}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(@PathParam("id") Integer id,Message entity,@PathParam("id2") Integer id2) {
       message.addMessageFromUser(entity,dialog.find(id), users.find(id2));
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Message entity) {
        super.edit(entity);
    }
   

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
