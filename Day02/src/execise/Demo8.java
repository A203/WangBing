package execise;
import java.util.Scanner;
public class Demo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������ͼ����ӡ����������� ��ӡ������
    Scanner input=new Scanner(System.in);
    System.out.print("�������к�:");
    int num=input.nextInt();
    for(int i=1;i<=num;i++){
    	for(int j=1;j<=i;j++){
    		System.out.print("*"+"\t");
    	}
    	System.out.println();
    }
	}

}
