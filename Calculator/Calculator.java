import java.util.*;

public class Calculator {

  public static double doCaculation() { //throw 'illegal op' exception
    // get users' input of numbers (double) and operations
    // require to hit enter (separate lines)

    double result = 0; //update the result
    Scanner scan = new Scanner(System.in);
    boolean end = false; //to terminate the program

    while (!end) {
      char nextOp = scan.next().charAt(0); //get the operation, should throw an 'illegal op' exception here
      if (!(op = '=')) {
        double nextNum = scan.nextDouble(); //get next number to update it with result
        result = calculate(result, nextOp, nextNum); //calculate!
      } else {
        end = true; //terminate when user enter '='
      }
    }

    return result;

  }

  public static double calculate(double a, char op, double b) {
    // your calculation methods here! USE SWICH!
  }



}
