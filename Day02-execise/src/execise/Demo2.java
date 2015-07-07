package execise;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[] arr={23,83,73,97,17,15};
    int sum=0;
    int max=arr[0];
    int min=arr[0];
    for(int i=0;i<arr.length;i++){
    	sum=sum+arr[i];
    	if(max<arr[i]){
    		max=arr[i];
    		continue;
    	}//continue的作用是当前面已执行 后一步无需再执行
    	if(min>arr[i]){
    		min=arr[i];
    	}
    }
    System.out.println("sum="+sum);
    System.out.println("max="+max);
    System.out.println("min="+min);
	}

}
