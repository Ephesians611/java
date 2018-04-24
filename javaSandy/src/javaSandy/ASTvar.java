package javaSandy;

import java.util.*;

public class ASTvar extends SimpleNode {
	public ASTvar(int id) {
		super(id);
	}

	public ASTvar(Prog2 p, int id) {
		super(p, id);
	}

	/* Added methods and field */

	public void setName(String n) {
		name = n;
	}

	public String toString() {
		return name;
	}

	public void printExpr() {
		System.out.print(name);
	}

	public Set<String> freeVars() {
		Set<String> fv = new HashSet<String>();

		fv.add(name);
		return fv;
	}

	public SimpleNode substitute(String varName, SimpleNode expr) {
		if (name == varName) {
			this.children[0] = expr.children[0];
		}
		return this;
	}

	private String name;
}
