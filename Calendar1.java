import java.util.Calendar;

// current date
public class Calendar1{
   public static void main(String[] args) {
   Calendar calendar = Calendar.getInstance();
   System.out.println("The current date is : " + calendar.getTime());
   calendar.add(Calendar.DATE, n);
 }
}

//future or past day
  public static void main(String[] args) {
  Calendar calendar = Calendar.getInstance();
  calendar.add(Calendar.DATE, n);
  if {(n<0)
  System.out.println("The date %f days later is ",n + calendar.getTime());
  } else {
  System.out.println("The date %f days ago was ",n + calendar.getTime());
  }
}

//future or past month
  public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, n);
    if {(n<0)
    System.out.println("The date %f months later is ",n + calendar.getTime());
    } else {
    System.out.println("The date %f months ago was ",n + calendar.getTime());
  }
}

//future or past year
public static void main(String[] args) {
  Calendar calendar = Calendar.getInstance();
  calendar.add(Calendar.YEAR, n);
  if {(n<0)
  System.out.println("The date %f years later is ",n + calendar.getTime());
  } else {
  System.out.println("The date %f years ago was ",n + calendar.getTime());
}
}
