package com.fumba.robotics;
class Node<T>
{ 	
    private T data;
    
    private Node next;
    
    //constructors
    public Node() 
    {
    }

    public Node(T d, Node n)
    {	       
	data = d;
	next = n;	
    }
    
    
    //selectors
    public T getData()
    {
	return data;
    }
    
    public Node getNext()
    {
	return next;
    }
    
    
    //mutators
    public void setNext(Node n)
    {
	next = n;
    }
    
    public void setData(T d)
    {
	data = d;
    }
    
}