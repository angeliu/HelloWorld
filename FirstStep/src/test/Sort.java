package test;

import java.util.Arrays;
import java.util.Scanner;

import javax.print.attribute.standard.NumberUpSupported;

import org.apache.xalan.xsltc.compiler.Template;
import org.xml.sax.HandlerBase;

public class Sort {
	public void bubbleSort1(int[] arr) {
		int i, j;
		for (i = 0; i < arr.length; i++) {
			for (j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}			
			}
		}
	}
	public void bubbleSort2(int[] arr) {
		int i, j;
		for (i = 0; i < arr.length; i++) {
			for (j = arr.length - 2; j >= i; j--) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
					
			}
		}
	}
	public void bubbleSort3(int[] arr) {
		int i, j;
		boolean flag = true;
		for (i = 0; i < arr.length && flag; i++) {
			flag = false;
			for (j = arr.length - 2; j >= i; j--) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
					flag = true;
				}
					
			}
		}
	}
	public void selectSort(int[] arr) {
		int i, j, min;
		for (i = 0; i < arr.length - 1; i++) {
			min = i;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j])
					min = j;
			}
			if (min != i) {
				int tmp = arr[min];
				arr[min] = arr[i];
				arr[i] = tmp;
			}
				
		}	
	}
	public void insertSort(int[] arr) {
		int i, j;
		for (i = 2; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				int tmp = arr[i];
				for (j = i - 1; arr[j] > tmp; j--) {
					arr[j + 1] = arr[j];
				}
				arr[j + 1] = tmp;
			}
		}
	}
	public void shellSort(int[] data) {
		    int j = 0;  
	        int temp = 0;  
	        for (int increment = data.length / 2; increment > 0; increment /= 2) {  
	            for (int i = increment; i < data.length; i++) {  
	                temp = data[i];  
	                for (j = i; j >= increment; j -= increment) {  
	                    if(temp < data[j - increment]){  
	                        data[j] = data[j - increment];  
	                    }else{  
	                        break;  
	                    }  
	                }   
	                data[j] = temp;  
	            }  
	        }  
	}
	public void heapSort(int[] arr) {
		int i ;
		for (i = arr.length/2; i > 0; i--) {
			heapAdjust(arr, i, arr.length);
		}
		
		for (i = arr.length - 1; i > 0; i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapAdjust(arr, 0, i - 1);
					
		}
	}
	public void heapAdjust(int[] arr, int i, int length) {
		int tmp, j;
		tmp = arr[i];
		for (j = 2 * i; j < length; j *= 2) {
			if (j < length && arr[j] < arr[j + 1]) {
				j++;
			}
			if (tmp >= arr[j]) 
				break;
			arr[i] = arr[j];
			i = j;
		}
		arr[i] = tmp;
	}
	public void heapSort1(int[] arr) {
		int i ;
		for (i = arr.length/2; i > 0; i--) {
			heapAdjust(arr, i, arr.length);
		}
		
		for (i = arr.length - 1; i > 0; i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapAdjust(arr, 0, i - 1);
					
		}
	}
	public void heapAdjust1(int[] arr, int i, int length) {
		int tmp, j;
		tmp = arr[i];
		for (j = 2 * i; j < length; j *= 2) {
			if (j < length && arr[j] < arr[j + 1]) {
				j++;
			}
			if (tmp >= arr[j]) 
				break;
			arr[i] = arr[j];
			i = j;
		}
		arr[i] = tmp;
	}


	public void quickSort(int[] arr, int low, int high){
		if(arr == null || arr.length == 0 || low > high) 
			return;
		if (low < high) {
			int mid = partition(arr, low, high);
			quickSort(arr, low, mid - 1);
			quickSort(arr, mid + 1, high);
		}
	}
	public int partition(int[] arr, int low, int high) {
		int tmp = arr[low];
		
		while (low < high) {
			while (low < high && arr[high] >= tmp) {
				high--;
			}			
			arr[low] = arr[high];
			while (low < high && arr[low] <= tmp) {
				low++;
			}
			
			arr[high] = arr[low]; 
		}
		arr[low] = tmp;	
		return high;		
	}
	
	public int[] mergeSort(int[] arr, int low, int high) {
		int mid = (low + high)/2;
		if (low < high) {
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
		return arr;
	}
	public void merge(int[] arr, int low, int mid, int high) {
		int[] tmp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j])
				tmp[k++] = arr[i++];
			else
				tmp[k++] = arr[j++];
		}
		while (i <= mid) {
			tmp[k++] = arr[i++];
		}
		while(j <= high)
			tmp[k++] = arr[j++];
		for (int k2 = 0; k2 < tmp.length; k2++) {  
            arr[k2 + low] = tmp[k2];  
        }  
			
	}
	
	public static void main(String[] args) {
		int[] arr = {10,5,2,1,4,3,6,8,9,7};
//		Scanner sc = new Scanner(System.in);
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = sc.nextInt();
//		}
		Sort s = new Sort();
		int[] tmp = s.mergeSort(arr, 0, 9);
		int[] a = Arrays.copyOfRange(tmp, 0, 10);
		for(int tmp1 : a)
			System.out.println(tmp1 + ",");
	}
}
