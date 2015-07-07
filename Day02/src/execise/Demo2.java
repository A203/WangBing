package execise;
import java.util.Scanner;
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner scanner=new Scanner(System.in);
		     String dayString=scanner.nextLine();
		     int day=0;
		   //将所有输入字符转换成小写格式
		     switch (dayString.toLowerCase())
		     {
		         case "monday":day=1;break;
		         case "tuesday":day=2;break;
		         case "wednesday":day=3;break;
		         case "thursday":day=4;break;
		         case "friday":day=5;break;
		         case "saturday":day=6;break;
		         case "sunday":day=7;break;  
		         default:day=0;
		     }
		     if(day==0)
		     {
		    	 System.out.println("无效输入");
		     }
		     else
		     {
		         System.out.println(day);
		     }
	}

}
