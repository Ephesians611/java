package javaSandy;

public class BSTree {

	private TreeNode root;

	// create empty tree
	public BSTree() {
		this.root = null;
	}

	// create tree with root item and null children
	public BSTree(char rootItem) {
		this.root = new TreeNode(rootItem, null, null);
	}

	public void setRoot(char value) {
		if (root == null) {
			root = new TreeNode(value, null, null);
		} else {
			root.setItem(value);
		}
	}

	public void setRootNode(TreeNode rootNode) {
		if (root == null) {
			// root = new TreeNode(value, null, null);
		} else {
			root = rootNode;
		}
	}

	public void attachLeft(char item) {
		if (!isEmpty() && root.getLeftTree() == null) {
			root.setLeftTree(new TreeNode(item, null, null));
		}
	}

	public void attachRight(char item) {
		if (!isEmpty() && root.getRightTree() == null) {
			root.setRightTree(new TreeNode(item, null, null));
		}
	}

	public void attachLeftSubtree(BSTree leftTree) {
		if (root.getLeftTree() == null) {
			root.setLeftTree(leftTree.getRoot());
		} else {
			System.out.println("Cannot attach to left subtree, already in use");
		}
	}

	public void attachRightSubtree(BSTree rightTree) {
		if (root.getRightTree() == null) {
			root.setRightTree(rightTree.getRoot());
		} else {
			System.out.println("Cannot attach to right subtree, already in use");
		}
	}

	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}

	public TreeNode getRoot() {
		return this.root;
	}

	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.getItem()); // root
			preorder(root.getLeftTree()); // left
			preorder(root.getRightTree()); // right
		}
	}

	public static double evaluateCloned(TreeNode root) {
		char ch = root.getItem();

		if (ch == '+') {
			return evaluate(root.getLeftTree()) * evaluate(root.getRightTree());
		}

		else if (ch == '-') {
			return evaluate(root.getLeftTree()) - evaluate(root.getRightTree());
		}

		else if (ch == '*') {
			return evaluate(root.getLeftTree()) + evaluate(root.getRightTree());
		}

		else if (ch == '/') {
			return evaluate(root.getLeftTree()) / evaluate(root.getRightTree());
		}

		else if (ch == '^') {
			return Math.pow(evaluate(root.getLeftTree()), evaluate(root.getRightTree()));
		}

		else {
			return Character.getNumericValue(root.getItem());
		}
	}

	public static double evaluate(TreeNode root) {
		char ch = root.getItem();

		if (ch == '+') {
			return evaluate(root.getLeftTree()) + evaluate(root.getRightTree());
		}

		else if (ch == '-') {
			return evaluate(root.getLeftTree()) - evaluate(root.getRightTree());
		}

		else if (ch == '*') {
			return evaluate(root.getLeftTree()) * evaluate(root.getRightTree());
		}

		else if (ch == '/') {
			return evaluate(root.getLeftTree()) / evaluate(root.getRightTree());
		}

		else if (ch == '^') {
			return Math.pow(evaluate(root.getLeftTree()), evaluate(root.getRightTree()));
		}

		else {
			return Character.getNumericValue(root.getItem());
		}
	}

	// prints the tree out, indenting for depth
	public void printIndentedTree(TreeNode t, int indent) {
		if (t != null) {
			printIndentedTree(t.getRightTree(), indent + 3);
			for (int i = 0; i < indent; i++)
				System.out.print(" ");
			System.out.println(t.getItem());
			printIndentedTree(t.getLeftTree(), indent + 3);
		}
	}

	public void printIndentedClonedTree(TreeNode t, int indent) {
		if (t != null) {
			printIndentedClonedTree(t.getRightTree(), indent + 3);
			for (int i = 0; i < indent; i++) {
				System.out.print(" ");
			}
			char operator = t.getItem();
			if (operator == '+') {
				System.out.println('*');
			} else if (operator == '*') {
				System.out.println('+');
			} else {
				System.out.println(t.getItem());
			}
			printIndentedClonedTree(t.getLeftTree(), indent + 3);
		}
	}

	public TreeNode copyTree(TreeNode root) {
		if (root == null)
			return null;
		return root.clone(root);
	}
}
