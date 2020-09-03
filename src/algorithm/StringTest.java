package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Hello";
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		System.out.println(sb);
		String.valueOf(2);
		
		int[] citations = {3,0,6,1,5};
		Integer[] cit = new Integer[citations.length];
		for(int i=0;i<citations.length;i++) {
			cit[i]=citations[i];
		}
        Arrays.sort(cit,new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                    return -1;
                else if(o2>o1)
                    return 1;
                else
                    return 0;
            }
        });
	}

}
