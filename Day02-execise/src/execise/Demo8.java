package execise;

public class Demo8 {
	public static void main(String [] args){
		int sum=0;
		int all[]=new int[20];
		int ping[]=new int[20];
		int score[][]={{1,80,61,87,45,78},{2,87,60,89,45,78},{3,87,69,80,45,78},
				{4,87,69,89,40,77},{5,87,69,89,45,75},{6,80,69,79,45,76},
				{7,81,60,79,45,78},{8,87,69,80,45,78},{9,87,61,89,40,78},
				{10,87,65,89,45,70},{11,87,69,89,40,78},{12,83,69,69,45,78},
				{13,81,60,69,45,78},{14,80,69,89,45,78},{15,84,69,89,40,78},
				{16,80,69,79,45,78},{17,84,69,89,45,78},{18,85,69,89,45,70},
				{19,87,69,59,40,78},{20,85,69,80,45,78}};
	
	String name[]={"C++","Java","Servlet","JSP","EJB"};
	System.out.print("ѧ��\t");
	for(int i=0;i<5;i++)
	{
		System.out.print(name[i]+"\t");
	}
	System.out.println();
	for(int i=0;i<20;i++)
	{
		for(int j=0;j<6;j++)
		{
			System.out.print(score[i][j]+"\t");	
			all[i]+=score[i][j]-i;//��ÿ���˵��ܷ�,����ѧ��
		}
		System.out.println();
		
	}
	//��all[0]��all[19]����ÿ���˵��ܷ��ˣ���д������������
	for(int i=1;i<all.length+1;i++)
	{
		all[i-1]-=i;//��Ϊѧ��Ҳ�����棬������ѧ��
	    System.out.println("��"+i+"�����ܷ�"+all[i-1]);
	}
	
}
}