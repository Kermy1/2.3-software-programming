package leertaak_2;

import java.util.Stack;

import multiformat.Rational;

public class Main {
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addNode(50, "node 50");
		tree.addNode(25, "node 25");
		tree.addNode(75, "node 75");
		tree.addNode(1, "node 1");
		tree.preOrderTraverse();
	}
	

}
