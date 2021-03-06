/**
 *  Tests for the Expr class
 **/  
public class ExprTest {
  public static void main(String argv[]){
    double[] varVals 
      = {  0.0,   1.0,   2.0,    3.0,   4.0,   5.0,   6.0, 
          -1.0,  -5.0,   0.125, 10.0,   3.5,   2.1,   5.4,
          14.0,  15.0,  16.0,   17.0,  18.0,  19.0,  20.0,
          -0.3,  20.0,   2.0,    4.0, 100.0 }; 
 
    Expr e1 = new Expr("( 2 + 3 )");    
    Expr e2 = new Expr("( ( 2 + 3 ) - 4 )");    
    Expr e3 = new Expr("( 2 + ( 3 * 4 ) )");    
    Expr e4 = new Expr("( ( 2 + 3 ) * 4 )");    
    Expr e5 = new Expr("( 2 + ( 3 * ( 4 / 5 ) ) )");    
    Expr e6 = new Expr("( ( ( 2 + ( 3 * ( ( 4 + 5 ) / 6 ) ) ) + ( 7 * 8 ) ) - 9 )");
    
    Expr ea = new Expr(3.0);
    Expr eb = new Expr(7.0);
    Expr ec = new Expr(14.0);
    Expr ed = new Expr(ea,'+',eb);
    Expr ee = new Expr(ed,'*',ec);
    Expr ef = new Expr("( ( 3.0 + x ) * ( 14.0 + 9.0 ) )"); // 3 x + 14 9 + *
    Expr eg = new Expr("( x + ( ( 12.0 - y ) * ( x + 3 ) ) )");
    Expr eh = new Expr("( ( z + 1.0 ) + ( ( 12.0 - y ) * ( ( z + 1.0 ) + 3.0 ) ) )");
    Expr ei = new Expr("( ( ( i + 9.0 ) + 1.0 ) + ( ( 12.0 - y ) * ( ( ( i + 9.0 ) + 1.0 ) + 3.0 ) ) )");
    // etc
    
    System.out.println("\n*** Tests for the constructors and fromPostfix ***");
    checkEq(ee,new Expr("( ( 3.0 + 7.0 ) * 14.0 )"));
    checkEq(ee,Expr.fromPostfix("3.0 7.0 + 14.0 *"));
    
    // // // // // // // // // // // // // // // // // // // // 
    System.out.println("\n*** Tests for toInfix ***");
    checkEq(ef,new Expr(ef.toInfix()));
    checkEq(eg,new Expr(eg.toInfix()));
    checkEq(eh,new Expr(eh.toInfix()));
    // add more
            
    
    // // // // // // // // // // // // // // // // // // // // 
    System.out.println("\n*** Tests for toPostfix ***");
    checkEq(ef,Expr.fromPostfix(ef.toPostfix()));
    checkEq(eg,Expr.fromPostfix(eg.toPostfix()));
    checkEq(eh,Expr.fromPostfix(eh.toPostfix()));
    // add more     
             
    // // // // // // // // // // // // // // // // // // // // 
    System.out.println("\n*** Tests for eval ***");
    evalTest(ef,ef.eval(varVals),115.0);
    evalTest(ef,eg.eval(varVals),42.0);
    evalTest(ef,eh.eval(varVals),933.0);
    // add more 

                
    // // // // // // // // // // // // // // // // // // // // 
    System.out.println("\n*** Tests for simplify ***");
    checkEq(ef.simplify(),new Expr("( ( 3.0 + x ) * 23.0 )"));
    checkEq(eg.simplify(),new Expr("( x + ( ( 12.0 - y ) * ( x + 3 ) ) )"));
    checkEq(eh.simplify(),new Expr("( ( z + 1.0 ) + ( ( 12.0 - y ) * ( ( z + 1.0 ) + 3.0 ) ) )"));
    // add more 
    
    
    // // // // // // // // // // // // // // // // // // // // 
    System.out.println("\n*** Tests for substitute ***");
    // ADD MORE!!!
    checkEq(Expr.subst(eg,'x',new Expr("( z + 1 )")),eh); 
    checkEq(Expr.subst(eh,'z',new Expr("( i + 9.0 )")),ei);// ( x + ( ( 12.0 - y ) * ( x + 3 ) ) )
  }
  
  ////////////////////////////////////////////////////////////////////
  // Utility tests  
  
  /** Tests if two Expr's are equal and fusses if they are not. 
    * @param e1 the first Expr
    * @param e2 the second Expr
    */
  public static void checkEq(Expr e1,Expr e2) {
    if (e1.equals(e2))      
      System.out.print("Passed equality test for   ");
    else
      System.out.print("FAILED!! equality test for ");
    System.out.println(e1.toInfix() + " and " + e2.toInfix());
  }
  
  /** Tests if an Expr evaluates to an expected value. 
    * @param e the Expr for the test
    * @param actual the value of e.eval(varVals) from main
    * @param expected the expected value of the evaluation.
    */
  public static void evalTest(Expr e,double actual,double expected) {
    if (actual==expected)
      System.out.println("Passed, " + e + " evaluates to " + expected);
    else
      System.out.println("FAILED!! " + e + " evaluates to " + actual 
                           + " but " + expected + " was expected");
  }
}