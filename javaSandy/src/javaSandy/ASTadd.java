package javaSandy;
public class ASTadd extends SimpleNode {
  public ASTadd(int id) {
    super(id);
  }

  public ASTadd(Prog2 p, int id) {
    super(p, id);
  }

  /* Added method */ 

  public void printExpr() {
      System.out.print("+");
  }
}
