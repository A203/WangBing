package execise;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub Scanner input=new Scanner(System.in);
		Scanner input=new Scanner(System.in);
		System.out.println("«Î ‰»Î––∫≈:");
		 int num=input.nextInt();
		 for(int i=1;i<=num;i++){
			 // ‰»Îø’∏Ò
			 for(int j=1;j<=num-i;j++){
			   System.out.print(" ");
			   }
			 // ‰»Î–«∫≈
			   for(int k=1;k<=i*2-1;k++){
			   System.out.print(i);
			  }
		      System.out.println();
		}

	}

}
