import java.util.*;

public class CalculatorFunction {

  public static void main(String[] args) {
    CalculatorFunction cf = new CalculatorFunction();
    /*
    CalculatorFunction.BasicOp basicOp = cf.new BasicOp();
    basicOp.doCalculation();
    */
    CalculatorFunction.ExpOp expOp = cf.new ExpOp();
    expOp.pow(2.5,5.4);
    expOp.square(121);
  }

  class BasicOp {


    // method to check if there's a space between the op and the input number

    void doCalculation() { //throw 'illegal op' exception
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

    void instruction() {
      System.out.println("Hello, I am your basic operations math calculator assistant");
      System.out.println("Start calculating your math equation by inputting a '+' or '-',");
      System.out.println("followed by a space ' ', then the first number in your equation, then hit enter!");
      System.out.println("  Example:+ 4[Enter]");
      System.out.println("Then enter one of the following operations: '+','-','/','*' followed by a space ' ', and a number");
      //System.out.println("Example: + 4[Enter]");
      System.out.println("  Example:/ 2[Enter]");
      System.out.println("Keep entering operations and numbers until your entire equation is inputted");
      System.out.println("When you are ready to calculate the answer input '=' and press enter!");
      //System.out.println("Example: + 4[Enter]");
      //System.out.println("Example: / 2[Enter]");
      //System.out.println("Example: * 5[Enter]");
      //System.out.println("Example: =[Enter]");
      System.out.println("___________________________________________________");
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
    void pow(double a, double b){
      System.out.printf("%.2f to the power of %.2f is %.2f %n",a,b,Math.pow(a,b));
    }

    void square(double a){
      System.out.printf("The square root of %.2f is %.2f %n",a,Math.sqrt(a));
    }

  }

  class AdvancedOp{
    void factorial(double n) {

    }

    void primeCheck(int p) {

    }

    void GCD(int a, int b) {
      long n = a;
      long m = b;

      while (m>0){
        long tmp = n%m;
        n=m;
        m=tmp;
        System.out.printf("The GCD of %d and %d is %d%n",a,b,CalcGCD(a,b));

      }

    }

    void LCM(int a, int b) {
      long l = (a*b)/n;
      System.out.printf("The LCM of %d and %d is %d%n",a,b,l);
      
    }
  }


}
