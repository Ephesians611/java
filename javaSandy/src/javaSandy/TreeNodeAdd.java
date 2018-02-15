package javaSandy;

public class TreeNodeAdd extends TreeNode {

	TreeNodeAdd(char item) {
		super(item);
		// TODO Auto-generated constructor stub
	}

	public static double evaluate(TreeNode leftNode, TreeNode rightNode) {
		return leftNode.getItem() + rightNode.getItem();
	}
}
