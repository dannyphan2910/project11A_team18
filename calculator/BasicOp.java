package calculator;

import java.util.*;

public class BasicOp {

  public static void doCalculation() {
    instruction();

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

  static void instruction() {
    System.out.println("_______________________________________________________________________________");
    System.out.println();
    System.out.println("👋🏼  Hello, I am your Basic Operations Math Calculator Assistant 👋🏼 ");
    System.out.println();
    System.out.println("Start calculating your math equation by inputting a '+' or '-',");
    System.out.println("Followed by a space ' ', Then the first number in your equation, then hit enter!");
    System.out.println();
    System.out.println("        → Example:+ 4[Enter]");
    System.out.println();
    System.out.println("Then enter one of the following operations: ");
    System.out.println("'+','-','/','*' followed by a space ' ', and a number");
    System.out.println();
    System.out.println("        → Example:/ 2[Enter]");
    System.out.println();
    System.out.println("Keep entering operations and numbers until your entire equation is inputted");
    System.out.println("When you are ready to calculate the answer input '=' and press enter!");
    System.out.println();
    System.out.println("_____________________________________________________________________________");
  }

  static double calculate(double a, char op, double b) {
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

  static void UnknownOpException(char op){
    System.out.println("Symbol is unvalid, I do not recognize the operation" + op);
  }

  static void DivideByZeroException() {
    System.out.println("This division is invalid because you divided by 0");
  }
}
