import java.util.*;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
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
