package execise;
import java.util.Scanner;
public class Demo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//三角形图案打印，输入多少行 打印多少行
    Scanner input=new Scanner(System.in);
    System.out.print("请输入行号:");
    int num=input.nextInt();
    for(int i=1;i<=num;i++){
    	for(int j=1;j<=i;j++){
    		System.out.print("*"+"\t");
    	}
    	System.out.println();
    }
	}

}
