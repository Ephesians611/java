package javaSandy;

import java.util.*;

public class ASTappl extends SimpleNode {
	public ASTappl(int id) {
		super(id);
	}

	public ASTappl(Prog2 p, int id) {
		super(p, id);
	}

	/* Added method */

	public void printExpr() {
		System.out.print("(");
		((SimpleNode) jjtGetChild(0)).printExpr();
		System.out.print(" ");
		((SimpleNode) jjtGetChild(1)).printExpr();
		System.out.print(")");
	}

	public Set<String> freeVars() {
		SimpleNode c0 = (SimpleNode) children[0];
		SimpleNode c1 = (SimpleNode) children[1];

		Set<String> c0fv = c0.freeVars();
		Set<String> c1fv = c1.freeVars();

		c0fv.addAll(c1fv);

		return c0fv;
	}

	public SimpleNode substitute(String varName, SimpleNode expr) {
		SimpleNode c0 = (SimpleNode) this.children[0];
		SimpleNode c1 = (SimpleNode) this.children[1];
		
		if (c0.toString() == varName) {
			c0.children[0] = expr.children[0];
		}
		if (c1.toString() == varName) {
			c0.children[0] = expr.children[0];
		}
		
		c0.substitute(varName, expr);
		c1.substitute(varName, expr);
		
		return this;
	}
}
