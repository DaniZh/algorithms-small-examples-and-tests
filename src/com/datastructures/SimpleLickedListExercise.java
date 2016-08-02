package com.datastructures;

import java.util.LinkedList;

public class SimpleLickedListExercise {

	private int size = 0;
	Node head = null;
	
	public void add(Node nextNode){
		if(nextNode == null){
			return;
		}
		if(this.head == null){
			head = nextNode;
			
		}else{
			Node currentNode = this.head;
			while (currentNode.hasNext()) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(nextNode);
		}
		this.size ++;
	};
	
	public Node getNode(int index){
		
		if(this.size-1 <= index || index < 0 || this.size == 0){
			return null;
		}
		Node currNode = head;
		while(index > 0){
			currNode = currNode.getNextNode();
		}
		return currNode;
	};

	public boolean deleteNode(int index){
	    if(this.size-1< index || index< 0 || this.size == 0){
	    	return false;
	    }

	    Node  currNode = this.head;
	   
	   for(int i =0;i< index-1; i++){
		   currNode = currNode.getNextNode();
	   }
	   Node tail = currNode;
	   if(index==0){
		   this.head = this.head.getNextNode();
	   }else
	   if(tail.hasNext()){
		   currNode.setNextNode(tail.getNextNode());
	   }else{
		   currNode.setNextNode(null);
	   }
	   tail.setNextNode(null);;
	   this.size --;
	   return true;
	}

	public void addNodeAt(int index, Node data){
		if (this.size<index || index<0){
			return;
		}
		Node currNode = head;
		for (int i =0 ;i < index; i++){
			currNode = currNode.getNextNode();
		}
		Node tail = currNode.getNextNode();
		data.setNextNode(tail);
		currNode.setNextNode(data);
		this.size++;
	}
	
	public int getSize(){
		return this.size;
	}

	public void listAll(){
		Node tmp = head;
		for (int i = 0 ; i<this.size;i++){
			System.out.println(tmp.getData());
			tmp = tmp.getNextNode();
			}
	}
	
	public static void main(String[] args) {
		

		Node a = new Node(1, null);
		Node b = new Node(2, null);
		Node c = new Node(3, null);
		Node d = new Node(4, null);
		Node e = new Node(5, null);
		Node f = new Node(4, null);
		SimpleLickedListExercise ll = new SimpleLickedListExercise();
		ll.add(a);
		ll.add(b);
		ll.add(c);
		
		ll.add(d);
		ll.add(e);
		ll.listAll();
		ll.deleteNode(0);
		System.out.println("--------------------");
		ll.listAll();
		ll.addNodeAt(3, f);
		ll.listAll();
	}
	
}
