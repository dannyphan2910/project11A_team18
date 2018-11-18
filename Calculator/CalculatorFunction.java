import java.util.*;

public class CalculatorFunction {

  public static void main(String[] args) {
    //for testing
    Calculator clerk = new doCalculation();
    try
    {
        System.out.println("Calculator is on.");
        System.out.print("Format of each line: ");
        System.out.println("operator space number");
        System.out.println("For example: + 3");
        System.out.println("To end, enter the letter e.");
        clerk.doCalculation();
    }
    catch (UnknownOpException e)
    {
        clerk.handleUnknownOpException(e);
    }
    catch (DivideByZeroException e)
    {
        clerk.handleDivideByZeroException(e);
    }
    System.out.println("The final result is " + clerk.getResult());
    System.out.println("Calculator program ending.");
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
      if (b==0)
      throw new DivideByZeroException();
      updatedAnswer = a/b;
      break;
      case '*':
      updatedAnswer = a*b;
      break;
      default: throw new UnknownOpException(op);
    }
    return updatedAnswer;
  }

  public void handleDivideByZeroException
  (
      DivideByZeroException e
  )
  {
      System.out.println("Dividing by zero.");
      System.out.println("Program aborted");
      System.exit(0);
  }

  public void handleUnknownOpException
  (
      UnknownOpException e
  )
  {
      System.out.println(e.getMessage());
      System.out.println("Try again from the beginning:");

      try
      {
          System.out.print("Format of each line: ");
          System.out.println("operator number");
          System.out.println("For example: + 3");
          System.out.println("To end, enter '='.");
          doCalculation();
      }
      catch (UnknownOpException e2)
      {
          System.out.println(e2.getMessage());
          System.out.println("Try again at some other time.");
          System.out.println("Program ending.");
          System.exit(0);
      }
      catch (DivideByZeroException e3)
      {
          handleDivideByZeroException(e3);
      }
  }


}
