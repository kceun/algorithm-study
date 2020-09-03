package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Fun1759 {

	public static int wordCnt, N;
	public static ArrayList<Character> arr = new ArrayList<>();
	public static boolean visit[];
	public static String moeum = "aeiou";
	public static void main(String[] args) throws FileNotFoundException {		
		System.setIn(new FileInputStream("Fun1759.txt"));
		Scanner sc = new Scanner(System.in);
		
		wordCnt = sc.nextInt();
		N = sc.nextInt();
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr.add(sc.next().charAt(0));
		}
		
		//오름차순 정렬
		Collections.sort(arr);
		
	
		dfs(0,0,"",0,0);

		

	}
	
	public static void dfs(int idx, int cnt, String pw,int m, int j) { //idx, 총 갯수, 만들어지는 pw내용, 모음, 자음
		//종료조건
		//wordCnt와 동일한 갯수인가?
		//모음이 최소 1개 , 자음이 최소 2개가 있는가?
		if(cnt==wordCnt && m >=1 && j >=2 ) {
			System.out.println(pw);
			return;
		}
		
		for (int i = idx; i < N; i++) {
			char ch = arr.get(i); //idx문자
			
			//이미 방문했던 곳인가?
			if(visit[i])
				continue;

			//방문처리
			visit[i] = true;
			
			//모음인가? 자음인가?
			if(moeum.contains(String.valueOf(ch)))
				dfs(i,cnt+1,pw+ch,m+1,j);
			else
				dfs(i,cnt+1,pw+ch,m,j+1);
			
			//방문false처리
			visit[i] = false;
		}
		
		
	}

}
