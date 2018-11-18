import java.util.*;

public class CalculatorFunction {

  public static void main(String[] args) {
    CalculatorFunction cf = new CalculatorFunction();
    CalculatorFunction.BasicOp basicOp = cf.new BasicOp();
    basicOp.doCalculation();
  }

  class BasicOp {
    void instruction() {
      //your code here
    }

    // method to check if there's a space between the op and the input number

    void doCalculation() { //throw 'illegal op' exception
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

      System.out.println(result);

    }

    double calculate(double a, char op, double b) {
      double updatedAnswer = 0;
      switch (op) {
        case '+': updatedAnswer = a + b; break;
        case '-': updatedAnswer = a - b; break;
        case '*': updatedAnswer = a * b; break;
        case '/':
          if (b==0) {
            DivideByZeroException();
          } else {
            updatedAnswer = a / b;
          }
          break;
        default: UnknownOpException(op);
      }

      return updatedAnswer;
    }

    void UnknownOpException(char op){
      System.out.println("Symbol is unvalid, I do not recognize the operation" + op);
    }

    void DivideByZeroException() {
      System.out.println("This division is invalid because you divided by 0");
    }
  }

  class ExpOp {
    void instruction() {
      // instruction code
    }

    public double pow (double a, double b){
      int powAnswer = (int) Math.pow(a,b);
    }

    public double square (double a){
      int squareAnswer = (int) Math.sqrt(a);

    }

  }

  class AdvancedOp{

  }


}
