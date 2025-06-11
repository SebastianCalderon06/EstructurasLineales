package controller;

import org.w3c.dom.Node;

import models.Contacto;
import models.LinkedList;
import models.NodeGeneric;


public class ControllerDao {

    private LinkedList<NodeGeneric<Contacto>> contacts;

    public ControllerDao(LinkedList<NodeGeneric<Contacto>> contacts) {
        this.contacts = contacts;
    }

    

    public ControllerDao() {
        this.contacts = new LinkedList<>();
    }



    public LinkedList<NodeGeneric<Contacto>> getContacts() {
        return contacts;
    }

    public void setContacts(LinkedList<NodeGeneric<Contacto>> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contacto contact) {
        contacts.appendToTail(contact);
    }

 public Contacto buscarContacto(String name) {
        for (NodeGeneric<Contacto> node : contacts) {
            Contacto contact = node.getValue();
            if (contact.getNombre().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public boolean eliminarContacto(String name) {
        for (NodeGeneric<Contacto> node : contacts) {
            Contacto contact = node.getValue();
            if (contact.getNombre().equals(name)) {
                contacts.remove(node);
                return true;
            }
        }
        return false;
    }

    public void imprimirContacto() {
        if (contacts.isEmpty()) {
            System.out.println("No hay contactos");
        } else {
            for (NodeGeneric<Contacto> node : contacts) {
                System.out.println(node.getValue());
            }
}}
}


    





