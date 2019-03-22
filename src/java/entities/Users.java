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
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String firstName;
    private String lastName;
    private String age;
   
    @ManyToMany
    private List<Dialog> dialog;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="userSend")
    private List <Message> message;

    
    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return firstName +" "+lastName;
    }

    @XmlTransient
    public List<Dialog> getDialog() {
        return this.dialog;
    }

    public void setDialog(List<Dialog> dialog) {
        this.dialog = dialog;
    }
        public void addDialog(Dialog entity_2) {
        if(getDialog().contains(entity_2)){}
        else{
        getDialog().add(entity_2);
        entity_2.getUser().add(this);
        }
    }

    
    public void addMessage(Message entity_2) {
        getMessage().add(entity_2);
    }

    public List <Message> getMessage() {
        return message;
    }

    public void setMessage(List <Message> message) {
        this.message = message;
    }
    



    
}
