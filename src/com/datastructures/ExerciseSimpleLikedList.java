package com.datastructures;

import java.util.LinkedList;

public class ExerciseSimpleLikedList {

	private int size;
	Node head;

	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (size <= 0) {
			this.head = node;
		} else {
			Node tail = this.head;
			while (tail.hasNext()) {
				tail = tail.getNextNode();
			}
			tail.setNextNode(node);
		}
		this.size++;
	}

	public boolean delete(int index) {

		if (index > size - 1) {
			return false;
		}
		int tmp = 0;
		if (index == 0) {
			this.head = this.head.getNextNode();
		} else {
			Node tail = this.head;
			while(tmp<index-1){
				tail = tail.getNextNode();
				tmp++;
			}
			tail.setNextNode(tail.getNextNode().getNextNode());
		}
		this.size --;
		return true;
	}

	public void addIndex(int index, Node node) {
		if (index > size ) {
			return;
		}
		if (index == 0) {
			node.setNextNode(this.head);
			this.head = node;
		} else {
			int tmp = 0;
			Node tail = this.head;
			while (tmp <= index - 1) {
				tmp++;
				tail = this.head.getNextNode();
			}
			node.setNextNode(tail.getNextNode());
			tail.setNextNode(node);
		}
		this.size++;
	}

	public Node getIndex(int index) {

		int tmp = 0;
		Node tail = this.head;
		while (tmp < index) {
			tail = tail.getNextNode();
			tmp++;
		}
		return tail;
	}

	public void listAll (){
		for(Node x = this.head; x!=null; x=x.getNextNode()){
			System.out.println(x.getData());
		}
	}
	
	public static void main(String[] args) {
		
		Node a = new Node(1, null);
		Node b = new Node(2, null);
		Node c = new Node(3, null);
		Node d = new Node(4, null);
		Node e = new Node(5, null);
		Node f = new Node(4, null);
		ExerciseSimpleLikedList ll = new ExerciseSimpleLikedList();
		ll.add(a);
		ll.add(b);
		ll.add(c);
		ll.add(d);
		ll.add(e);
		ll.listAll();
		ll.delete(0);
		System.out.println("dd");
		ll.listAll();
		ll.addIndex(4, f);
		System.out.println("dd");
		ll.listAll();
	}
	
}
