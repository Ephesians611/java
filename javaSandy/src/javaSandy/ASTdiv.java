package javaSandy;
public class ASTdiv extends SimpleNode {
  public ASTdiv(int id) {
    super(id);
  }

  public ASTdiv(Prog2 p, int id) {
    super(p, id);
  }

  /* Added method */
  
  public void printExpr() {
      System.out.print("/");
  }
}

