package javaSandy;
public class ASTnum extends SimpleNode {
  public ASTnum(int id) {
    super(id);
  }

  public ASTnum(Prog2 p, int id) {
    super(p, id);
  }

  /* Added methods and field */

  public void setValue(String n) {
    value = Integer.parseInt(n);
  }

  public String toString() {
    return Integer.toString(value);
  }

  public void printExpr() {
      System.out.print(value);
  }

  private int value;
}
