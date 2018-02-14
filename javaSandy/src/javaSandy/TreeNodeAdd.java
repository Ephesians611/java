package javaSandy;

public class TreeNodeAdd extends TreeNode {

	TreeNodeAdd(char item) {
		super(item);
		// TODO Auto-generated constructor stub
	}

	public static double evaluate(TreeNode root) {
		return evaluate(root.getLeftTree()) + evaluate(root.getRightTree());
	}
}
