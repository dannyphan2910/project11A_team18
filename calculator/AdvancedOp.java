package calculator;

import java.util.*;

public class AdvancedOp {

  public static void factorial() {
    Scanner scan = new Scanner(System.in);
    System.out.println();
    System.out.println("Ollie is asking (dearly) the number you want the factorial of. Please! 👏");
    System.out.println();
    int n = scan.nextInt();
    System.out.println();
    int k = 1;
    for (int i = n; i >= 1; i--) {
      k = k*i;
    }
    System.out.printf("The factorial of %d is %d%n",n,k);
  }

  public static void primeCheck() {
    Scanner scan = new Scanner(System.in);
    System.out.println();
    System.out.println("So Ollie heard you want to check out a prime number. 😉");
    System.out.println();
    System.out.println("What's your number?");
    System.out.println();
    int p = scan.nextInt();
    System.out.println();
    for(int i=2; i<=Math.sqrt(p); i++){
      if (p%i==0) {
        System.out.printf("%d is not prime%n it is %d * %d%n%n",p,i,p/i);
        return;
      }
    }
    System.out.printf("%d is prime%n",p);
  }

  public static void GCD() {
    Scanner scan = new Scanner(System.in);
    System.out.println();
    System.out.println("Ollie wants to know the two numbers you want to find the GCD of. Please! 👏");
    int a = scan.nextInt();
    int b = scan.nextInt();
    System.out.println();
    long n = a;
    long m = b;

    while (m>0){
      long tmp = n%m;
      n=m;
      m=tmp;
    }

    System.out.printf("The GCD of %d and %d is %d%n",a,b,n);
  }

  public static void LCM() {
    Scanner scan = new Scanner(System.in);
    System.out.println();
    System.out.println("Ollie wants to know the two numbers you want to find the LCM of. Please! 👏");
    int a = scan.nextInt();
    int b = scan.nextInt();
    System.out.println();
    long n = a;
    long m = b;

    while (m>0){
      long tmp = n%m;
      n=m;
      m=tmp;
    }

    long l = (a*b)/n;
    System.out.printf("The LCM of %d and %d is %d%n",a,b,l);
  }
}
