package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SWEA1208 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("1208input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int n=0;n<10;n++) {
			int t = sc.nextInt();
			int[] boxes = new int[100];
			int cha = 0;
			
			for(int tc=0;tc<100;tc++) {
				boxes[tc]=sc.nextInt();
			}
			
			while(t>0) {
				Arrays.sort(boxes);
				boxes[0]++;
				boxes[boxes.length-1]--;
				t--;
			}
			
			Arrays.sort(boxes);
			cha = boxes[boxes.length-1]-boxes[0];
			System.out.println("#"+(n+1)+" "+cha);
		}
	}

}
