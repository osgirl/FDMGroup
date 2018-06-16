package com.fdmgroup.collection;

import java.util.LinkedList;
import java.util.Queue;

public class StringLinkedList {
	public static void main(String[] args){
		Queue<String> queue = new LinkedList<String>();
		queue.add("Hi");
		queue.add("Everyone!");
		
//		System.out.println("queue.poll(): " + queue.poll()); //removes the first string and returns it.
//		System.out.println("queue.poll(): " + queue.poll()); //removes the next string and returns it.
		
		System.out.println(queue.peek());
		queue.remove();

		System.out.println(queue.peek());
		queue.remove();
		
		System.out.println(queue.size());
		
//		System.out.println(queue.peek()); //will return null
//		queue.remove(); //will return an exception
	}
}
