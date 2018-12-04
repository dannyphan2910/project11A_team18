package calculator;

import java.util.*;

public class ExpOp {
  public static void pow(){
    Scanner scan = new Scanner(System.in);
    System.out.println();
    System.out.println("Ollie wants to know your base and your exponent. Please! 👏");
    System.out.println();
    System.out.println("What's your base, you beautiful thing?");
    double a = scan.nextDouble();
    System.out.println();
    System.out.println("What about your exponent?");
    double b = scan.nextDouble();
    System.out.println();
    System.out.printf("%.2f to the power of %.2f is %.2f %n",a,b,Math.pow(a,b));
  }

  public static void squareRoot(){
    Scanner scan = new Scanner(System.in);
    System.out.println();
    System.out.println("Ollie wants to know the number you want to square root. Please! 👏");
    double a = scan.nextDouble();
    System.out.println();
    System.out.printf("The square root of %.2f is %.2f %n",a,Math.sqrt(a));
  }

}
