package com.exercise.datastructures;

import java.util.LinkedList;

public class ExersizeSimpleLinkedistNew {

	private int size;
	private Node head;

	public void add(Node nextNode) {
		if (nextNode == null) {
			return;
		}
		nextNode.setNextNode(head);
		this.head = nextNode;
		this.size++;
	}

	public boolean deleteNode(int index) {

		if (index > this.size - 1) {
			return false;
		}
		if (index == 0) {
			this.head = this.head.getNextNode();
		} else {
			Node previos = null;
			int tmp = 0;
			for (Node x = this.head; x != null; x = x.getNextNode()) {
				if (tmp == index) {
					previos.setNextNode(x.getNextNode());
					break;
				}
				previos = x;
				tmp ++;
			}
		}

		this.size--;
		return true;
	}

	public void addNodeAt(int index, Node node) {
		if (index > this.size) {
			return ;
		}
		if(index == 0){
			node.setNextNode(this.head);
		}else {
			Node prev = null;
			int tmp = 0;
			for (Node x =this.head; x!=null; x = x.getNextNode()){
				if(tmp == index-1){
					node.setNextNode(x.getNextNode());
					x.setNextNode(node);
				}
				tmp ++;
			}
		}
		
		this.size++;
	}

	public Node getNodeAt(int index) {
		if (index > this.size -1) {
			return  null;
		}
		Node current = this.head;
		while(index>0){
			current = current.getNextNode();
			index --;
		}
		return current;
	}
	
	public void listAll (){
		for (Node x =this.head; x!= null; x= x.getNextNode()){
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
		ExersizeSimpleLinkedistNew ll = new ExersizeSimpleLinkedistNew();
		ll.add(a);
		ll.add(b);
		ll.add(c);
		ll.add(d);
		ll.add(e);
		ll.listAll();
		ll.deleteNode(4);
		System.out.println("dd");
		ll.listAll();
		ll.addNodeAt(4, f);
		System.out.println("dd");
		ll.listAll();
	}
}
