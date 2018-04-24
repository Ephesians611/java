package javaSandy;
import java.util.*;

public class ASTlamb extends SimpleNode {
	private int uniqueId = 0;
	
	private char getUniqueName()
	{
		return (char)uniqueId++;
	}
	
  public ASTlamb(int id) {
    super(id);
  }

  public ASTlamb(Prog2 p, int id) {
    super(p, id);
  }

  /* Added method */

  public void printExpr() {
      System.out.print("(L ");
      ((SimpleNode)jjtGetChild(0)).printExpr();
      System.out.print(" . ");
      ((SimpleNode)jjtGetChild(1)).printExpr();
      System.out.print(")");
  }

  public Set<String> freeVars() {
    SimpleNode c0 = (SimpleNode)children[0];
    SimpleNode c1 = (SimpleNode)children[1];

    Set<String> fv = c1.freeVars();
    String c0Name = c0.toString();
    fv.remove(c0Name);

    return fv;
  }
  
  public SimpleNode substitute(String varName, SimpleNode expr) {
	    SimpleNode c0 = (SimpleNode)children[0];
	    SimpleNode c1 = (SimpleNode)children[1];
	    char uniqueName;
	    		
		if (this.toString() == varName) {
			return this;
		}
		if (this.toString() != varName && !expr.freeVars().contains(c0)) {
			c1.substitute(varName, expr);
		}
		if (this.toString() != varName && expr.freeVars().contains(c0)) {
			//generate a unique name
			uniqueName = getUniqueName();
			this.children[0].
			c1.substitute(varName, expr);
			//modify E by substituting the variable name in the left child with the generated unique name and 
			//all the free occurrences of the variable name in the right subtree of E with the generated unique name, 
			//and substitute the free occurrences of x in the modified E with E1
		}
		return this;
	}
}
