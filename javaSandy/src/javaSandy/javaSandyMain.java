package javaSandy;

public class javaSandyMain {

	
	public static void main( String[] args ) {
	      boolean p, q;

	      // Part 1: Exercise the conditional operators AND and OR .....

	      System.out.println( "Part 1: Exercise conditional AND and OR operators");
	      System.out.println( "=========================================");
	      System.out.println( "       p        q     (p ^ q)     (p v q)" );
	      System.out.println( "=========================================");

	      p =  true; q = true;
	      System.out.printf(  "%8s %8s %11s %11s\n", p, q, p && q, p || q );
	      p = false; q = true;
	      System.out.printf(  "%8s %8s %11s %11s\n", p, q, p && q, p || q );
	      p =  true; q = false;
	      System.out.printf(  "%8s %8s %11s %11s\n", p, q, p && q, p || q );
	      p = false; q = false;
	      System.out.printf(  "%8s %8s %11s %11s\n", p, q, p && q, p || q );

	      System.out.println( "==========================================");

	      // Part 2: the conditional OR operator (i.e., ||)

	      System.out.println( "");
	      System.out.println( "Part 2: Exercise logical negation operator");
	      System.out.println( "=========================================");
	      System.out.println( "       p       !p                        " );
	      System.out.println( "=========================================");

	      p = true; 
	      System.out.printf(  "%8s %8s \n", p, !p );
	      p = false; 
	      System.out.printf(  "%8s %8s \n", p, !p );

	      System.out.println( "=========================================");

	   } 
}
