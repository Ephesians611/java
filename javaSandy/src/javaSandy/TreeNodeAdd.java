package javaSandy;

public class TreeNodeAdd extends TreeNode {

	TreeNodeAdd(char item) {
		super(item);
		// TODO Auto-generated constructor stub
	}

	public static double evaluate(TreeNode leftNode, TreeNode rightNode) {
		char leftCh = leftNode.getItem();
		char righttCh = rightNode.getItem();

		if ((leftCh != '+' && leftCh != '-' && leftCh != '*' && leftCh != '/')
				&& (righttCh != '+' && righttCh != '-' && righttCh != '*' && righttCh != '/')) {
			return leftNode.getItem() + rightNode.getItem();
		}

		return 0;

	}
}
