package javaSandy;

import java.io.File;
import java.util.Scanner;

public class p7 {

	public static void main(String[] args) throws Exception {
		System.out.println(">>> Simplified Arithmetic Post-fix Expression Evaluator <<<");
		System.out.println("Enter a simplified arithmetic post-fix expression:");
		// File path for compilation on CS server
		// String fileName = "/home/courses/cs2411/ProgramFiles/" + args[0];

		// 1. Read in a simplified arithmetic expression and build its binary tree
		// representation;
		String fileName = "p7.dat";

		File file = new File(fileName);
		Scanner fInput = new Scanner(file);

		Stack stack = new Stack();

		while (fInput.hasNext()) {
			String expression = fInput.next();
			char ch;

			// this assumes valid file input i.e. only numbers and operators
			for (int i = 0; i < expression.length(); i++) {
				ch = expression.charAt(i);

				// ch is an operator
				if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
					BSTree tree = new BSTree(ch); // create new tree from operand
					tree.attachRightSubtree(stack.pop()); // attach right subtree
					tree.attachLeftSubtree(stack.pop()); // attach left subtree

					stack.push(tree);
				}

				// ch is a number
				else {
					BSTree tree = new BSTree(ch);
					stack.push(tree);
				}

			}

			BSTree tree = stack.pop();
			System.out.println(expression);
			System.out.println("\n");

			// 2. Print its tree representation;
			System.out.println("The tree representation:");
			tree.printIndentedTree(tree.getRoot(), 0);
			System.out.println("\n");

			// 3. Evaluate the tree;
			System.out.println("The value: " + BSTree.evaluate(tree.getRoot()));
			// System.out.print("Prefix: ");
			// tree.preorder(tree.getRoot());
			System.out.println("\n");

			// 4. Clone the tree and swap the ' + ' and ' * ' operators in the cloned tree
			// to produce a new tree;
			BSTree treeCopy = new BSTree(' ');
			treeCopy.setRootNode(tree.copyTree(tree.getRoot()));

			// 5. Print the new tree;
			System.out.println("The new tree:");
			treeCopy.printIndentedTree(treeCopy.getRoot(), 0);
			System.out.println("\n");

			// 6. Evaluate the new tree; and
			System.out.println("The value of the new tree: " + BSTree.evaluate(treeCopy.getRoot()));

			// 7. Re-evaluate the orginal tree.
			System.out.println("The value of the original tree: " + BSTree.evaluate(tree.getRoot()));

			System.out.println("\n\n");
		}
	}
}
