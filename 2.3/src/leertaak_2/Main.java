package leertaak_2;

import java.util.Stack;

import multiformat.Rational;

public class Main {
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addNode(6, "F");
		tree.addNode(7, "G");
		tree.addNode(8, "I");
		tree.addNode(9, "H");
		tree.addNode(2, "B");
		tree.addNode(1, "A");
		tree.addNode(4, "D");
		tree.addNode(3, "C");
		tree.addNode(5, "E");
		tree.postOrderTraverse();
	}
	

}
