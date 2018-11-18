import java.util.*;

public class CalculatorFunction {

  public static void main(String[] args) {
    //for testing
  }

  public static double doCalculation() { //throw 'illegal op' exception
    // get users' input of numbers (double) and operations
    // require to hit enter (separate lines)

    double result = 0; //update the result
    Scanner scan = new Scanner(System.in);
    boolean end = false; //to terminate the program

    while (!end) {
      char nextOp = scan.next().charAt(0); //get the operation, should throw an 'illegal op' exception here
      if (!(nextOp == '=')) {
        double nextNum = scan.nextDouble(); //get next number to update it with result
        result = calculate(result, nextOp, nextNum); //calculate!
      } else {
        end = true; //terminate when user enter '='
      }
    }

    return result;

  }

  public static double calculate(double a, char op, double b) {
    double updatedAnswer;
    switch (op) {
      case '+':
      updatedAnswer = a+b;
      break;
      case '-':
      updatedAnswer = a-b;
      break;
      case '/':
      if (b==0) {
        DivideByZeroException();
      }
      updatedAnswer = a/b;
      break;
      case '*':
      updatedAnswer = a*b;
      break;
      default: UnknownOpException(op);
    }
    return updatedAnswer;
  }

  public static void UnknownOpException(char op){
    System.out.println("Symbol is unvalid, I do not recognize the operation" + op);
  }
  
  public static void DivideByZeroException() {
    System.out.println("This division is invalid because you divided by 0");
  }

}
