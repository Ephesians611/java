package javaSandy;
public class ASTmul extends SimpleNode {
  public ASTmul(int id) {
    super(id);
  }

  public ASTmul(Prog2 p, int id) {
    super(p, id);
  }

  /* Added method */

  public void printExpr() {
      System.out.print("*");
  }
}

