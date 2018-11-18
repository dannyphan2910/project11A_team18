public static void main(String[] args){
  double addition (double a, double b){
  return a+b;
}
}

public static void main(String[] args){
  double subtraction (double a, double b){
  return a-b;
}
}

public static void main (String[] args){
  double division (double a, double b){
  return a/b
}
}

public static void main (String[] args){
  double multiplication (double a, double b){
  return a*b
}
}

// lcm and gcd
public static void main(String[] args){
  System.out.println("Enter two whole numbers, one per line: ");
  long num1 = TextIO.getlnLong();
  long num2 = TextIO.getlnLong();

  long n = num1;
  long m = num2;
  long count = 0;
  while (m>0){
    long tmp = n%m;
    n=m;
    m=tmp;

    count++;
  }

<<<<<<< HEAD
  public static double calculate(double a, char op, double b) throws DivideByZeroException, UnknownOpException
  {
    // your calculation methods here! USE SWICH!
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



=======
  long lcm=num1*num2/n;

  System.out.printf("The GCD of %d and %d is %d%n",num1,num2,n);
  System.out.printf("The LCM of %d and %d is %d%n",num1,num2,lcm);

  // prime numbers between Range
  public static void main(String[] args){
    System.out.println("Enter two positive integers");
    int a = TextIO.getlnInt();
    int b = TextIO.getlnInt();
    for(int i=a; i<=b; i++){
      prime(i);
    }
    System.out.println();

  }
  public static void prime(int n){
    for(int i=2; i<=Math.sqrt(n); i++){
      if (n%i==0) {
        return;
      }
    }

    System.out.print(n + " ");
>>>>>>> 7f5c2956013af3bb7143a6646ccb779b8ddc5ffb
  }

//average
public static void main(String[] args){

    double a = num1;
    double b = num2;
    double avg = (a+b)/2;

    System.out.printf("The average is %8.2f%n",avg);

//
