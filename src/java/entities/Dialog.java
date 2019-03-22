/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author olegm
 */
@Entity
@XmlRootElement
public class Dialog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="dialog_id")
    private List <Message> messages;
    
    
    private String name;

    
    @ManyToMany(mappedBy = "dialog")
    private List<Users> user; 
    

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "entities.Dialog[ id=" + id + " ]";
    }

    @XmlTransient
    public List <Message> getMessages() {
        return this.messages ;
    }

    public void setMessages(List <Message> messages) {
        this.messages = messages;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Users> getUser() {
        return user;
    }

    public void setUser(List<Users> user) {
        this.user = user;
    }
    
    
       public void addUser(Users entity_1) {
        if(getUser().contains(entity_1)){}
        else{
        getUser().add(entity_1);
        }
    }
        public void addMessage(Message entity_1) {
            if(getMessages().contains(entity_1)){}
            else{
        getMessages().add(entity_1);}
    }
    
}
