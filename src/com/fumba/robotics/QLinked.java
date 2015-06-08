package com.fumba.robotics;
/*
 * QLinked
 * uses imaginary Node class -- similar to IntNode with Object data field 
 * O(1) for enqueue/dequeue/front
 *
 */

public class QLinked implements QInterface {

    // create an empty queue
    public QLinked() { }

    // enqueue a new object to the tail of the queue (line)
    public void enqueue(Object data) {
        Node newNode = new Node(data, null);

        // be sure to update head if it was originally empty
        if (length == 0) 
            head = tail = newNode; 
        else {
            tail.setNext(newNode);
            tail = newNode;
        }

        length++;

        //debug();
    }

    // dequeue the object from the beginning of the queue
    // this object should be removed from the queue
    public Object dequeue() {
        if (empty()) return null;
        else {
            Object tmp = head.getData();
            head = head.getNext();

            // Q. is this necessary?
            // set tail to null if queue becomes empty
            // if (head == null) tail = null;

            length--;
            return tmp;
        }
    }

    // returns the object from the top of the queue
    // this object should NOT be removed from the queue
    public Object getFront() {
        if (empty()) return null;
        else         return head.getData();
    }

    // returns the # of data items on the queue
    public int size() {
        return length;
    }

    // returns true if queue is empty, false otherwise.
    public boolean empty() {
        return (length == 0);
    }

    // debug
    public void debug() {
        if (!empty()) {
            System.out.println("--- Queue Content begin ---"); 
            Node current = head;
            while (current != null) {
                System.out.println("\t" + current.getData().toString());
                current = current.getNext();
            }
            System.out.println("--- Queue Content end ---"); 
        }
    }

    // private member variables
    private Node head, tail;
    private int length;
}
