/*********************************************************
* Quadradic is a simple representation of quadratic expressions.
*
* @author
*   <b><i>I forgot to include my name, so please take off some points</i></b>
* @version
*   July 22, 2014
*
**********************************************************/
public class Quadratic {
  /** The x<sup>2</sup> coeffecient */
  double a;
  /** The x<sup>1</sup> coeffecient */
  double b;
  /** The constant coeffecient      */
  double c;
  /////////////////////////////////////////////////////////
  /**
   * Initialize a quadratic expression with all coeffecients 0.0 
   **/   
  public Quadratic() { 
    a = b = c = 0.0;
  }

  /////////////////////////////////////////////////////////
  /**
   * Initialize a quadratic expression with the specified
   * values of the coeffecients.
   * @param aVal
   *   the initial value of the x<sup>2</sup> coeff.
   * @param bVal
   *   the initial value of the x<sup>1</sup> coeff.
   * @param cVal
   *   the initial value of the constant coeff.
   **/   
  public Quadratic(double aVal, double bVal, double cVal) {
    a = aVal;
    b = bVal;
    c = cVal;
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Sets the x<sup>2</sup>-coeff.
   * @param  aVal
   *   the value that the x<sup>2</sup> coeff is set to.
   **/   
  public void setA(double aVal) { 
    a = aVal;
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Gets the x<sup>2</sup>-coeff.
   * @return
   *   The value of the x<sup>2</sup> coeff
   **/   
  public double getA() { 
    return a; /* fix! */
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Sets the x<sup>1</sup>-coeff.
   * @param bVal
   *   the value that the x<sup>1</sup> coeff is set to.
   **/   
  public void setB(double bVal) { 
   b = bVal;
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Gets the x<sup>1</sup>-coeff.
   * @return
   *   The value of the x<sup>1</sup> coeff
   **/   
  public double getB() { 
    return b; /* fix! */
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Sets the constant-coeff.
   * @param cVal
   *   the value that the x<sup>2</sup> coeff is set to.
   **/   
  public void setC(double cVal) { 
    c = cVal;
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Gets the constant-coeff.
   * @return
   *   The value of the x<sup>0</sup> coeff
   **/   
  public double getC() { 
    return c; /* fix! */
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Evaluates the quadratic expression at x.
   * @param x
   *   the value at which to evaluate the expression
   * @return
   *   The value of the expression at x
   **/   
  public double eval(double x)  {
    double ans = a*(Math.pow(x,2)) + b*x + c ;
    return ans; /* fix! */
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Adds two quadratic expressions
   * @param q1
   *   the first quadratic expression
   * @param q2
   *   the second quadratic expression
   * @return
   *   the quadratic expression that is the sum of q1 and a2
   **/   
  public static Quadratic sum(Quadratic q1, Quadratic q2) {
    double a = q1.getA() + q2.getA() ;
    double b = q1.getB() + q2.getB();
    double c = q1.getC() + q2.getC();
    
    return new Quadratic(a,b,c);  /* fix! */
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Multiply the coeffs by a scaling value
   * @param r
   *   the scaling value
   * @param q
   *   the quadratic to scale
   * @return
   *   the resulting quadratic expression
   **/   
  public static Quadratic scale(double r, Quadratic q) {
    double a = r* q.getA();
    double b = r* q.getB();
    double c = r* q.getC();
    return new Quadratic(a,b,c);  /* fix! */
  }
  
  /////////////////////////////////////////////////////////
  /**
   * The number of roots of a quadratic expression
   * @return
   *   The number of roots: either 0, 1, 2, or 3 (which
   *   stands for infinity)
   **/   
  public int numRoots() {
    double dis;
    int r;
    dis = Math.pow(b,2) - (4*a*c);
    if(dis < 0)
      r = 0;
    else if (dis == 0)
      r = 1;
    else
      r = 2;
    
    return r;  /* fix! */
  }
  
  /////////////////////////////////////////////////////////
  /**
   * The smallest root of the quadratic expression
   * @return
   *   the smallest root of the quadratic expression.
   *   If there are infinitely many roots or no roots, 0.0
   *   is returned.
   **/   
  public double smallRoot() {
     double ans1;
     double ans2;
     double ansf;
     ans1 = ((-1)*b + Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a);
     ans2 = ((-1)*b - Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a);
     if (ans1 < ans2) 
       ansf = ans1 ;
     else
       ansf = ans2;
     return ansf; /* fix! */
  }    

  
  /////////////////////////////////////////////////////////
  /**
   * The biggest root of the quadratic expression
   * @return
   *   the biggest root of the quadratic expression.
   *   If there are infinitely many roots or no roots, 0.0
   *   is returned.
   **/   
  public double bigRoot() {
     double ans1;
     double ans2;
     double ansf;
     ans1 = ((-1)*b + Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a);
     ans2 = ((-1)*b - Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a);
     if (ans1 > ans2) 
       ansf = ans1 ;
     else
       ansf = ans2;
     return ansf; /* fix! */ 
  }    
 
  /////////////////////////////////////////////////////////
  /**
   * Convert the Quadratic to a string for printing.
   * @return
   *   a Sting version of the Quadratic
   **/  
  public String toString() {
    return Double.toString(a) + "*x^2 + " +
           Double.toString(b) + "*x + " +
           Double.toString(c);
  }  
  
  /////////////////////////////////////////////////////////
  /**
   * <i>A test method:</i> Print the Quadratic and report on its roots.
   **/   
  public static void report(Quadratic q) {
    System.out.println(q+" has:");
    switch (q.numRoots()) {
      case 0: 
        System.out.println("  no roots");
        break;
      case 1: 
        System.out.println("  one root: "+q.smallRoot());
        break;
      case 2: 
        System.out.println("  two roots: "+q.smallRoot()+" and "+q.bigRoot());
        break;
      default: 
        System.out.println("  infinitely many roots");
        break;
    }       
  } 

  /////////////////////////////////////////////////////////
  /**
   * A test program for the Quadratic class
   **/   
  public static void main(String argv[]) {
    Quadratic q = new Quadratic();  
    
    //                            Expected Output
    report(q);                //  infinitely many roots
    
    q.setC(1);     report(q); //  no roots
    q.setB(-1);    report(q); //  one root: 1.0
    q.setA(1);     report(q); //  no roots
    q.setB(-2);    report(q); //  one root: 1.0
    q.setB(-3);    report(q); //  two roots: 0.3819660112501051 and 2.618033988749895
    
    // include more tests of, among other things, eval, scale, and sum.

  }
}