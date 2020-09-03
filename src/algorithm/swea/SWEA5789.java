package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SWEA5789 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("5789input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			int N =sc.nextInt();
			int Q =sc.nextInt();
			int[] box = new int[N];
			
			for(int i=1;i<=Q;i++) {
				int L = sc.nextInt();
				int R = sc.nextInt();
				
				for(int j=L-1;j<R;j++) {
					box[j]=i;
				}
			}
			
			System.out.print("#"+(tc+1));
			for(int i : box) {
				System.out.print(" "+i);
			}
			System.out.println();
		}
	}

}
