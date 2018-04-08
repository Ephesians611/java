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
      ((SimpleNode)jjtGetChild(0)).printExpr();
      System.out.print(" ");
      ((SimpleNode)jjtGetChild(1)).printExpr();
      System.out.print(")");
  }

  public Set<String> freeVars() {
    SimpleNode c0 = (SimpleNode)children[0];
    SimpleNode c1 = (SimpleNode)children[1];

    Set<String> c0fv = c0.freeVars();
    Set<String> c1fv = c1.freeVars();

    c0fv.addAll(c1fv);

    return c0fv;
  }

}
