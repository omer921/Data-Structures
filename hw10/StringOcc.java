import java.lang.ClassCastException;


/**********************************************************
 * 
 * A class to represent strings and a list of their
 * occurrences in a text.
 * 
 **********************************************************/

public class StringOcc implements Comparable {
  /** a string */
  public String  word;
  /** a list of lines on which the string occurs */
  public Node<Integer> head;

  /** Construct a StringOcc for String s and for 
    *   the head of a list of occurrences, node.
    * @param s a string
    * @param node the head of a list of line occurrences
    */
  public StringOcc(String s, Node<Integer> node) {
    word = s;   head = node;
  }
    
  ////////////////////////////////////////////////////////
  /** 
   * Compare two StringOcc's based on their Strings.
   * @param o the StringOcc to compare to this StringOcc.
   * @throws ClassCastException if o is something funky
   * @return the compareTo number based on how the two
   *   strings compare.
   **/
  public int compareTo(Object o) throws ClassCastException {
    if (!(o instanceof StringOcc)) throw new ClassCastException();
    String s = ((StringOcc) o).word;
    return word.compareTo(s);
  }

  ////////////////////////////////////////////////////////
  /** 
   * Construct a String representation of the StringOcc
   **/
  public String toString(){
    return word + ": " + listOfInts(head);
  }
  
  public String getWord(){
    return word;}
  
  public String listOfInts(Node<Integer> node) {
    String ans = "";
    while (node !=  null)
    {
     ans += " " + node.getData();
     node = node.getLink();
    }
    return ans; // This should be a list of the integers on the list
  }

}