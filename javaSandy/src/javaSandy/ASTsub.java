package javaSandy;
public class ASTsub extends SimpleNode {
  public ASTsub(int id) {
    super(id);
  }

  public ASTsub(Prog2 p, int id) {
    super(p, id);
  }

  /* Added method */

  public void printExpr() {
    System.out.print("-");
  }
}

