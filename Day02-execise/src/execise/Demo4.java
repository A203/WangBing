package execise;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr={14,35,83,94,93,85,74,62,46,34};
     int temp;
     for(int i=0;i<arr.length;i++){
    	 for(int j=0;j<arr.length-i-1;j++){
    		 if(arr[j+1]>arr[j]){
    			 temp=arr[j];
    			 arr[j]=arr[j+1];
    			 arr[j+1]=temp;
    		 }
    	 }
     }
     
     System.out.print("Ωµ–Ú≈≈¡–£∫");
     for(int i=0;i<arr.length;i++){	 
    	 System.out.print(arr[i]+"\t");
     }
	}

}
