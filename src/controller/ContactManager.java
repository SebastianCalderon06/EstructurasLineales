package controller;

import models.Contacto;
import models.LinkedList;
import models.NodeGeneric;

public class ContactManager {
    private LinkedList<Contacto> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contacto contact) {
        contacts.appendToTail(contact);
    }

    public Contacto findContactByName(String name) {
        NodeGeneric<Contacto> actual = contacts.getTop();
    
        while (actual != null) {
            Contacto contactoActual = actual.getValue();
            if (contactoActual.getNombre().equals(name)) {
                return contactoActual;
            }
            actual = actual.getNext();
        }
    
        return null;
    }

    public void deleteContactByName(String name) {
        NodeGeneric<Contacto> actual = contacts.getTop();
        NodeGeneric<Contacto> anterior = null;
    
        while (actual != null) {
            Contacto contactoActual = actual.getValue();
            if (contactoActual.getNombre().equals(name)) {
                if (anterior == null) { 
                    contacts.setTop(actual.getNext());
                    if (actual == contacts.getTail()) {
                        contacts.setTail(null);
                    }
                } else {
                    anterior.setNext(actual.getNext());
                    if (actual == contacts.getTail()) {
                        contacts.setTail(anterior);
                    }
                }
                contacts.setSize(contacts.getSize() - 1);
                System.out.println("Contacto eliminado.");
                return;
            }
            anterior = actual;
            actual = actual.getNext();
        }
    
        System.out.println("Contacto no encontrado.");
    }
    public void printList() {
        if (contacts.isEmpty()) {
            System.out.println("No hay contactos.");
            return;
        }

        NodeGeneric<Contacto> current = contacts.getTop();
        while (current != null) {
            Contacto c = current.getValue();
            System.out.println("- Nombre: " + c.getNombre() + ", Teléfono: " + c.getTelefono());
            current = current.getNext();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContactManager other = (ContactManager) obj;
        if (contacts == null) {
            if (other.contacts != null)
                return false;
        } else if (!contacts.equals(other.contacts))
            return false;
        return true;
    }

    
}


    





