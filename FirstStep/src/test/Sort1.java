package test;

import javax.mail.Flags.Flag;
import javax.sound.midi.MidiChannel;

import org.apache.axis2.deployment.util.TempFileManager;

public class Sort1 {  
	  public void selectSort(int[] a) {
		  if(a == null || a.length == 0) 
			  return;
		  for(int i = 0; i < a.length; i++) {
			  int min = i;
			  for(int j = i + 1; j < a.length; j++) {
				  if(a[j] < a[min])
					  min = j;
			  }
			  if(min != i) {
				  int tmp = a[i];
				  a[i] = a[min];
				  a[min] = tmp;
			  }
		  }
	  }
	  public void insertSort(int[] a) {
		  if(a == null || a.length == 0)
			  return;
		  int i, j;
		  int tmp;
		  for(i = 1; i < a.length; i++) {
			  tmp = a[i];
			  for(j = i - 1; j >= 0 && a[j] > tmp; j--) {
				  a[j + 1] = a[j];
			  }
			  a[j + 1] = tmp;
		  }
	  }
	  public void shellSort(int[] a) {
		  if(a == null || a.length == 0) 
			  return;
		  for(int increment = a.length/2; increment > 0; increment /= 2) {
			  for(int i = increment; i < a.length; i++) {
				  int j;
				  int tmp = a[i];
				  for(j = i; j >= increment; j -= increment) {
					  if(tmp < a[j - increment])
						  a[j] = a[j - increment];
					  else
						  break;
				  }
				  a[j] = tmp;
			  }
		  }
		  
	  }
	  public void sort(int[] a) {
		  if(a == null || a.length == 0)
			  return;
		  quickSort(a, 0, a.length - 1);
	  }
	  public void quickSort(int[] a, int low, int high) {
		  if(a == null || a.length == 0)
			  return;
		  if(low < high) {
			  int mid = partitionSort(a, low, high);
			  quickSort(a, low, mid - 1);
			  quickSort(a, mid + 1, high);
		  }  
	  }
	  public int partitionSort(int[] a, int low, int high) {
		  int tmp = a[low];
		  while(low < high) {
			  while(low < high && a[high] >= tmp)
				  high--;
			  a[low] = a[high];
			  while(low < high && a[low] <= tmp)
				  low ++;
			  a[high] = a[low];
		  }
		  a[low] = tmp;
		  return low;
	  }
	  public void mergeSort(int[] a, int low, int high) {
		  int mid = low + (high - low)/2;
		  if(low < high) {
			  mergeSort(a, low, mid);
			  mergeSort(a, mid + 1, high);
			  merge(a, low, mid, high);
		  }
	  }
	  public void merge(int[] a, int low, int mid ,int high) {
		  int i = low;
		  int j = mid + 1;
		  int[] res = new int[high - low + 1];
		  int count = 0;
		  while(i <= mid && j <= high) {
			  if(a[i] < a[j]) {
				  res[count++] = a[i++];
			  } else {
				  res[count++] = a[j++];
			  }
		  }
		  while(i <= mid)
			  res[count++] = a[i++];
		  while(j <= high)
			  res[count++] = a[j++];
		  for(int k1 = 0; k1 < res.length; k1++) {
			  a[k1 + low] = res[k1];
		  }
	  }
	  public void heapSort(int[] a) {
		  if(a == null || a.length == 0) 
			  return;
		  int i;
		  for(i = a.length/2; i >= 0; i--)
			  heapAdjust(a, i, a.length);
		  for(i = a.length - 1; i > 0; i--) {
			  int tmp = a[0];
			  a[0] = a[i];
			  a[i] = tmp;
			  heapAdjust(a, 0, i - 1);
		  }
	  }
	  public void heapAdjust(int[] a, int begin, int end) {
		  int tmp = a[begin];
		  int j;
		  for(j = (2 * begin); j < end - 1; j *= 2) {
			  if((j < end - 1)  && a[j] < a[j + 1])
				  j++;
			  if(tmp >= a[j])
				  break;
			  a[begin] = a[j];
			  begin = j;
		  }
		  a[begin] = tmp;
	  }
	  public static void main(String[] args) {
		 int[] a = {1, 3, 4, 5,8};
		 Sort1 qs = new Sort1();
		 //qs.bubbleSort(a);
		 //qs.insertSort(a);
		 //qs.shellSort(a);
	//	 qs.sort(a);
	//	 qs.mergeSort(a, 0, 5);
		 qs.heapSort(a);
		 for(int tmp: a)
			 System.out.println(tmp);
	}  
}