package javaSandy;
import java.util.*;

public class ASTlamb extends SimpleNode {
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

}
