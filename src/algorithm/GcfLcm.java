package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GcfLcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gcf g = new Gcf();
		Integer[] arr = {2,6,8,14};
		//System.out.println(g.solution(arr));
		Arrays.parallelSort(arr);
		
		ArrayList<String> a = new ArrayList<>();
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		StringBuilder sb = new StringBuilder();
		sb.reverse();
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}

}
class Gcf {
	  public int solution(int[] arr) {
	      int answer = 0;
	      int big =0;
	      int small=0;
	      int num = arr[0];
	      for(int i=1;i<arr.length;i++) {
	          num = lcm(num,arr[i]);
	          answer=num;
	      }
	      
	      return answer;
	  }

	    public int lcm(int n1,int n2) {
	        int big,small;
	        if(n1>=n2){
	            big = n1;
	            small = n2;
	        } else {
	            big = n2;
	            small = n1;
	        }
	        while(true) {
	            if(big%small==0) {
	                int gcf = small;
	                return gcf * (n1/gcf) * (n2/gcf);
	            } else {
	                int temp = big;
	                big = small;
	                small = temp%small;
	                //lcm(big,small);
	            }
	        }
	         
	    }
	}