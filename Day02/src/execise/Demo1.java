package execise;
import java.util.Scanner;
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner scanner=new Scanner(System.in);
     int day=scanner.nextInt();
     String monthString="";
     switch(day)
     {
         case 1:monthString="Monday";break;
         case 2:monthString="Tuesday";break;
         case 3:monthString="Wednesday";break;
         case 4:monthString="Thursday";break;
         case 5:monthString="Friday";break;
         case 6:monthString="Saturday";break;
         case 7:monthString="Sunday";break;  
         default:monthString="error day";
     }
         System.out.println(monthString);
	}

}
