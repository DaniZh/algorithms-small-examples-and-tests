package com.exercise.datastructures;

public class Node {

	private int data ;
	private Node nextNode;
	
	public Node(){
	}
	
	public Node(int data, Node nextNode){
		this.data = data;
		this.nextNode = nextNode;
	}
	
	public boolean hasNext(){
		return this.nextNode != null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((nextNode == null) ? 0 : nextNode.hashCode());
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
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		if (nextNode == null) {
			if (other.nextNode != null)
				return false;
		} else if (!nextNode.equals(other.nextNode))
			return false;
		return true;
	}

	
}
