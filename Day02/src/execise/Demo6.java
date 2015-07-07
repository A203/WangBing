package execise;

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 1-100之间的质数
//	int n,i;
//	System.out.println("1-100之间的质数：");
//    for(i=2;i<=100;i++)
//		for( n=2;n<=i;n++)
//		{
//			if(i%n==0&&i!=n)		
//			break;
//		    if(i==n)
//		    {
//			  System.out.println(i);			
//		    }
//	    }
    for(int n=2;n<=100;n++)
     {
    	boolean flag=true;
    	for(int k=2;k<n;k++)
    	{
    		if(n%k==0){
    		    flag=false;
    			break;}
    	}
     
    	if(flag)
    	{
    		System.out.println(n);
    	}
     }
	}
	
	}


