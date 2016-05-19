package test;

import java.util.Scanner;





public class TestMic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//while (sc.hasNext()) {
			int count = sc.nextInt();
			while (count-- > 0) {
				int n = sc.nextInt();
				int p = sc.nextInt();
				int w = sc.nextInt();
				int h = sc.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < arr.length; i++)
					arr[i] = sc.nextInt();
				int res = 0;
	            
	            for (int s = 1; s <= Math.min(w, h); s++) {
	                int col = w/s;
	                int row = h/s;
	                
	                int colNum=0;
	            	for(int i = 0; i<n; i++){
	                	int tmp = arr[i] % col==0 ? 0 : 1;
	                	colNum += arr[i] / col + tmp;
	            	}
	                if(colNum <= row * p){
	                	if(s > res)
	                		res = s;
	                }
	                else{
	                	continue;
	                }
	            }
	           		
				System.out.println(res);
			}
				
		}
		
	//}
}
