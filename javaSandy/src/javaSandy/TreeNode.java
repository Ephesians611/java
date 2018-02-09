package javaSandy;

/* This is a simple TreeNode that implements the Node interface. */

public class TreeNode {

	// class variables
	private char item;
	private TreeNode leftTree;
	private TreeNode rightTree;

	// constructors
	TreeNode(char item) {
		this.item = item;
		this.leftTree = null;
		this.rightTree = null;
	}

	TreeNode(char item, TreeNode leftTree, TreeNode rightTree) {
		this.item = item;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}

	// getters and setters
	public char getItem() {
		return item;
	}

	public void setItem(char item) {
		this.item = item;
	}

	public TreeNode getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(TreeNode leftTree) {
		this.leftTree = leftTree;
	}

	public TreeNode getRightTree() {
		return rightTree;
	}

	public void setRightTree(TreeNode rightTree) {
		this.rightTree = rightTree;
	}
}
