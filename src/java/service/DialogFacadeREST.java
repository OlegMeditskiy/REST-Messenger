/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.DialogDAO;
import DAO.MessageDAO;
import DAO.UserDAO;
import entities.Dialog;
import entities.Message;
import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author olegm
 */
@Stateless
@Path("dialog")
public class DialogFacadeREST extends AbstractFacade<Dialog> {
    
    @PersistenceContext(unitName = "MessagePU")
    private EntityManager em;
    
    @Inject
    DialogDAO dialog;
    
    @Inject
    UserDAO users;
    
    @Inject
    MessageDAO message;
    
    public DialogFacadeREST() {
        super(Dialog.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Dialog entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Dialog entity) {
        super.edit(entity);
    }
    

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Dialog find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("/getMessages/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Message> getMessages(@PathParam("id") Integer id) {
       return dialog.listAllMessages(super.find(id));
    }
    
    @GET
    @Path("/getUsers/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List <Users> getUsers(@PathParam("id") Integer id) {
       return dialog.listAllUsers(super.find(id));
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Dialog> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
