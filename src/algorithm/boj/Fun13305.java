package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun13305 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //도시 개수
		long[] road = new long[N-1];
		long[] town = new long[N];
		long ans = 0;
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < road.length; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < town.length; i++) {
			town[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		for (int i = 0; i < road.length; i++) {
			//처음엔 무조건 들려야 함
			ans+=(town[i]*road[i]);
			int next = i;
			//현재 도시가 다음 도시보다 리터당 주유비용이 더 싼지 비교하기
			//더 싸다면.. 다음 도시~도시로 이동하는 구간만큼을 미리 주유해놓기.
			//다다음 도시.. 다다다음 도시.. 도시 끝까지 비교하기
			//다음 거보다 주유비용이 작으면..? 그 다음 것도 보자..
			while(town[i]<town[next+1] && next+1 < road.length) {
				ans+=(town[i]*road[next+1]);
				next = next+1;
			}
			i = next;
			
		}
		
		System.out.println(ans);
		
	}

}
