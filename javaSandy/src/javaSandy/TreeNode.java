package javaSandy;

/* This is a simple TreeNode that implements the Node interface. */

public class TreeNode {

	// class variables
	private char item;
	private TreeNode leftTree;
	private TreeNode rightTree;
	TreeNodeNum tnn;

	// constructors
	TreeNode() {
		tnn = new TreeNodeNum();
		// this.item = tnn.getItem();
		// this.item = item;
		this.leftTree = null;
		this.rightTree = null;
	}

	TreeNode(char item) {
		// tnn = new TreeNodeNum(item);
		// this.item = tnn.getItem();
		this.item = item;
		this.leftTree = null;
		this.rightTree = null;
	}

	TreeNode(char item, TreeNode leftTree, TreeNode rightTree) {
		// tnn = new TreeNodeNum(item);
		// this.item = tnn.getItem();
		this.item = item;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}

	// getters and setters
	public char getItem() {
		// return tnn.getItem();
		return this.item;
	}

	public void setItem(char item) {
		this.item = item;
		tnn.setItem(item);
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

	public TreeNode clone(TreeNode root) {
		if (root == null)
			return null;
		TreeNode newNode = new TreeNode(root.getItem());
		newNode.setLeftTree(clone(root.getLeftTree()));
		newNode.setRightTree(clone(root.getRightTree()));
		return newNode;
	}
}
