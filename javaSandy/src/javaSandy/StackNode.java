package javaSandy;

public class StackNode {

	private BSTree tree;
	private StackNode next;

	// constructor
	public StackNode(BSTree tree, StackNode next) {
		this.tree = tree;
		this.next = next;
	}

	public void setTree(BSTree tree) {
		this.tree = tree;
	}

	public BSTree getTree() {
		return this.tree;
	}

	public void setNext(StackNode next) {
		this.next = next;
	}

	public StackNode getNext() {
		return this.next;
	}
}
