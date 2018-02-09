package javaSandy;

import java.util.ArrayList;
import java.util.List;

/**
 * An expression tree represents the hierarchical structure of a mathematical
 * expression. In this lab you will: - First implement an algorithm so that the
 * ExpressionTree constructor can take in any postfix notation expression and
 * build a tree for it. - If you have time, come up with and implement an
 * algorithm for finding the mathematical value of an expression tree.
 * 
 * @author arafferty
 * @author Jed Yang
 * @author YOUR NAME(S) HERE
 */
public class ExpressionTree {
	/**
	 * Class representing the nodes in the tree. Our binary tree only stores
	 * strings.
	 */
	private static class BinaryTreeNode {
		private String item;
		private BinaryTreeNode leftChild;
		private BinaryTreeNode rightChild;

		/** Returns the item represented by this node. */
		public String toString() {
			return item;
		}
	}

	// The root of this ExpressionTree
	private BinaryTreeNode root;

	/**
	 * Constructs an ExpressionTree that represents the expression written in
	 * postfix notation.
	 * 
	 * You should change this method to construct an expression tree that represents
	 * postfixNotation.
	 * 
	 * @param postfixNotation
	 */
	public ExpressionTree(String postfixNotation) {
		List<String> postfixNotationList = parseSpaceSeparatedStringIntoList(postfixNotation);
		// FIXME: Implement me!
	}

	/**
	 * Helper method that returns whether s is an arithmetic operator.
	 * 
	 * @param s
	 * @return true if s is an arithmetic operator
	 */
	private boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

	/**
	 * Prints out a representation of the tree to the console. The representation
	 * surrounds everything with parentheses to show the infix expression that is
	 * represented by this tree. This is an inorder traversal: we'll talk about
	 * other types of traversals next class.
	 * 
	 * If you have extra time, trace through the recursive calls with a small tree
	 * to make sure you understand how the tree is displayed.
	 */
	public void printExpression() {
		printExpressionHelper(root);
		System.out.println();
	}

	/**
	 * Helper method for display tree: recurses down left child, prints the node,
	 * and then recurses down right child.
	 * 
	 * @param node
	 *            root of the current subtree
	 */
	private void printExpressionHelper(BinaryTreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print("( ");
		printExpressionHelper(node.leftChild);

		// Why can we just put node here to print the item the node stores?
		System.out.print(node + " ");

		printExpressionHelper(node.rightChild);
		System.out.print(") ");
	}

	/**
	 * Displays an ASCII-art sort of representation of this tree (image-like text).
	 */
	public void printTree() {
		printNode(root);
	}

	/**
	 * Converts a space separated postfix notation string like "2 5 * 3 +" into a
	 * list filled with the items.
	 * 
	 * @param spaceSeparatedPostfixNotation
	 * @return list of numbers and operators in postfix notation
	 */
	private static List<String> parseSpaceSeparatedStringIntoList(String spaceSeparatedPostfixNotation) {
		String[] splitString = spaceSeparatedPostfixNotation.split(" ");
		List<String> postfixNotation = new ArrayList<String>();
		for (String s : splitString) {
			postfixNotation.add(s);
		}
		return postfixNotation;
	}

	/**
	 * Test out making an expression tree. A couple of test cases are given for you:
	 * you can add more if you like.
	 * 
	 * Implement the algorithm given in the lab to parse postfix notation into a
	 * tree. Your algorithm should be implemented in the constructor (or called by
	 * the constructor) so that the line: ExpressionTree tree = new
	 * ExpressionTree(postfixNotation); creates an expression tree that represents
	 * the String postfixNotation.
	 * 
	 * For debugging your code, you may find it very helpful to write down an
	 * expression and walk through on paper what your code does with that
	 * expression.
	 */
	public static void main(String[] args) {
		// Test your ExpressionTree class here
		String expression1 = "3 5 * 2 +";
		System.out.println("Displaying: " + expression1);
		ExpressionTree tree = new ExpressionTree(expression1);
		tree.printExpression();
		tree.printTree();

		String expression2 = "4 2 / 5 + 3 -";
		System.out.println("Displaying: " + expression2);
		tree = new ExpressionTree(expression2);
		tree.printExpression();
		tree.printTree();

		// bonus expression
		String expression3 = "1 2 * 3 4 - 5 6 * - 7 8 9 * - * +";
	}

	/***************************************************************************
	 * You can (and should, for now) ignore all code below this point! This code
	 * takes care of printing.
	 *
	 * Lightly modified from user post on stack overflow:
	 * http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	 */
	private static void printNode(BinaryTreeNode root) {
		int maxLevel = maxLevel(root);
		List<BinaryTreeNode> rootList = new ArrayList<BinaryTreeNode>();
		rootList.add(root);
		printNodeInternal(rootList, 1, maxLevel);
	}

	private static void printNodeInternal(List<BinaryTreeNode> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || areAllElementsNull(nodes)) {
			return;
		}
		int floor = maxLevel - level;
		int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		printWhitespaces(firstSpaces);

		List<BinaryTreeNode> newNodes = new ArrayList<BinaryTreeNode>();
		for (BinaryTreeNode node : nodes) {
			if (node != null) {
				System.out.print(node.item);
				newNodes.add(node.leftChild);
				newNodes.add(node.rightChild);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= edgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					printWhitespaces(edgeLines + edgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).leftChild != null)
					System.out.print("/");
				else
					printWhitespaces(1);

				printWhitespaces(i + i - 1);

				if (nodes.get(j).rightChild != null)
					System.out.print("\\");
				else
					printWhitespaces(1);

				printWhitespaces(edgeLines + edgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static int maxLevel(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(maxLevel(node.leftChild), maxLevel(node.rightChild)) + 1;
	}

	private static boolean areAllElementsNull(List<BinaryTreeNode> list) {
		for (BinaryTreeNode object : list) {
			if (object != null)
				return false;
		}
		return true;
	}

	// prints the tree out, indenting for depth
	public static void printTree(BinaryTreeNode t, int indent) {
		if (t != null) {
			printTree(t.rightChild, indent + 3);
			for (int i = 0; i < indent; i++)
				System.out.print(" ");
			System.out.println(t.item);
			printTree(t.leftChild, indent + 3);
		}
	}

}