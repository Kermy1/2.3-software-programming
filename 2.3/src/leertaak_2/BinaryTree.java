package leertaak_2;

import java.util.Stack;

public class BinaryTree {
	
	Node root;
	
	public void addNode(int key, String name)
	{	
		// Creates a new node with the given variables.
		Node newNode = new Node(key,name);
		
		// Makes the node the root if root doesn't allready contain a node.
		if(root == null)
		{
			root = newNode;
		} 
		else 
		{	
			// We make our focusnode our root since we start at the top of the tree.
			Node focusNode = root;
			
			Node parent;
			
			while(true)
			{
				// We make our focusnode the parent.
				parent = focusNode;
				
				// If the focusnode key is smaller than 
				if(key < focusNode.key)
				{
					focusNode = focusNode.leftChild;
					
					if(focusNode == null){
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					
					if(focusNode == null)
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	public void inOrderTraverse(){
		Node current = root; // Begin bij de root
		Stack<Node> nodeStack = new Stack<Node>();
		while(current != null || !nodeStack.isEmpty()){
			if(current != null){
				nodeStack.push(current);
				current = current.leftChild;
			}else{
				Node parent = nodeStack.pop();
				System.out.println(parent.toString());
				current = parent.rightChild;
			}
		}
	}
	public void preOrderTraverse(){
		Node current = root; // Begin bij de root
		Stack<Node> nodeStack = new Stack<Node>();
		while(current != null || !nodeStack.isEmpty()){
			if(current != null){
				nodeStack.push(current);
				System.out.println(current.toString());
				current = current.leftChild;
			}else{
				Node parent = nodeStack.pop();
				current = parent.rightChild;
			}
		}
	}
	public void postOrderTraverse(){
		Node current = root; // Begin bij de root
		Stack<Node> nodeStack = new Stack<Node>();
		while(current != null || !nodeStack.isEmpty()){
			if(current != null){
				nodeStack.push(current);
				current = current.leftChild;
			}else{
				Node parent = nodeStack.pop();
				if(parent.secondPop){
					//
					System.out.println(parent.toString());
				}else{
					parent.secondPop = true;
					current = parent.rightChild;
					nodeStack.push(parent);
				}
			}
		}
	}
	
}

/**
 * This class represents the nodes in the tree.
 * @author bonnemaj
 *
 */
class Node {
	
	/**
	 * These are the variables that represent the key and the name of the node.
	 */
	int key;
	String name;
	
	/**
	 * These variables are the children of this node.
	 */
	Node leftChild;
	Node rightChild;
	boolean secondPop;
	/**
	 * creates a new Node object and initiates the key variable and the name variable.
	 * @param key
	 * @param name
	 * @see #key
	 * @see #name
	 */
	public Node(int key,String name){
		this.key = key;
		this.name = name;
	}
	
	/**
	 * Makes a string of the information of this node.
	 */
	public String toString(){
		return name + " has the key: "+key;
	}
}