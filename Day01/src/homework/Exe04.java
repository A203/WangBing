package homework;
import java.util.Scanner;
public class Exe04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in); 
		System.out.println("请输入选择(1-3):");
		 int number=scanner.nextInt();
		 if(number==1)
		 {
			 System.out.println("增加一个学生");
		 }
		 if(number==2)
		 {
			 System.out.println("显示所有学生");
		 }
		 if(number==3)
		 {
			 System.out.println("退出程序");
		 }
		 
	}

}
