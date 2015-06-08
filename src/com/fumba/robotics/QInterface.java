package com.fumba.robotics;
/*
 * QInterface
 * specifies methods and any static constants for Queue
 *
 */

public interface QInterface {

    public void enqueue(Object item);

    public Object dequeue();

    public Object getFront();

    public int size();

    public boolean empty();

}
