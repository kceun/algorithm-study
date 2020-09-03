package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SWEA5431 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("5431input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt(); //제출한사람
			ArrayList<Integer> list = new ArrayList();
			ArrayList<Integer> ans = new ArrayList();
			
			for(int i=0;i<K;i++) {
				list.add(sc.nextInt());
			}
			
			for(int i=1;i<=N;i++) {
				ans.add(i);
			}
			
			for(int i=0;i<list.size();i++) {
				for(int j=0;j<ans.size();j++) {
					if(list.get(i)==ans.get(j)) {
						ans.remove(j);
					}
				}
			}
			
			Collections.sort(list);
			
			System.out.print("#"+(tc+1)+" ");
			for(int i : ans) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}
