package models;

import java.util.EmptyStackException;

public class LinkedList <T> {
    private NodeGeneric<T> top;
    private int size;
    private NodeGeneric<T> tail;

    public LinkedList() {
        this.top = null;
        this.tail = null;
        this.size = 0;
    }

    public NodeGeneric<T> getTop() {
        return top;
    }

    public void setTop(NodeGeneric<T> top) {
        this.top = top;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public NodeGeneric<T> getTail() {
        return tail;
    }

    public void setTail(NodeGeneric<T> tail) {
        this.tail = tail;
    }


    public boolean isEmpty(){
        return top == null;

    }

    public void appendToTail(T value){
        NodeGeneric<T> newNode = new NodeGeneric<T>(value);
        if (isEmpty()){
            top = newNode;
            tail = newNode;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public int findByValue(T value){
        int posicion = 0;
        NodeGeneric<T> node = top;
        while (node != null){
            if (node.getValue().toString().equals(value)) {
                return posicion;
            }
            node = node.getNext();
            posicion++;
        }
        return -1;
    
    }

        public void removeByName(T value) {
        if (isEmpty())
            throw new EmptyStackException();
        if (top.getValue().toString().equals(value)) {
            top = top.getNext();
            if (top == null) {
                tail = null;
            }
            size--;
            return;
        }
        NodeGeneric<T> actual = top;
        NodeGeneric<T> anterior = null;
        while (actual != null && !actual.getValue().toString().equals(value)) {
            anterior = actual;
            actual = actual.getNext();
        }
        if (actual != null) {
            anterior.setNext(actual.getNext());
            if (actual == tail) {
                tail = anterior;
            }
            size--;
        }    
    }
        public void printCola(){
            if(isEmpty()){
            System.out.println("Esta vacia");
            return;
        }else{
            NodeGeneric<T> actual = top;
            while(actual != null){
                System.out.print(actual.getValue() + " | ");
                actual = actual.getNext();
            }}
    }

 


    

    

    
}
