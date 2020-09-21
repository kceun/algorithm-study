package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun9465 {

	public static int[][] map;
	public static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[2][N];//[행][열]
			dp = new int[N][3]; //column을 기준으로 3가지 경우의 수 중 최대값을 담는 배열 [열][경우의수]
								// [n][0] : 해당 열에서 스티커를 뜯지 않는다.
								// [n][1] : 해당 열에서 위쪽 스티커를 뜯는다.
								// [n][2] : 해당 열에서 아래쪽 스티커를 뜯는다.
			
			//스티커 점수 넣기
			for (int i = 0; i < 2; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//첫번째 초기값 세팅
			dp[0][0]=0; //안뜯을 경우 누적점수는 0이다.
			dp[0][1]=map[0][0]; //위쪽을 뜯을 경우 위쪽스티커에 대한 점수 넣기
			dp[0][2]=map[1][0]; //아래쪽을 뜯을 경우 아래쪽스티커에 대한 점수 넣기
			
			//최대값 구하기 (column을 기준으로)
			for (int i = 1; i < N; i++) {
				//1. 아무것도 안 뜯을경우
				dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
				//2. 위쪽을 뜯을 경우
				dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + map[0][i]; //위쪽을 뜯을 경우 i-1의 열에서 변을 마주하는 위쪽거는 비교불가능.
				//3. 아래쪽을 뜯을 경우
				dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + map[1][i];
			}
			
			System.out.println(Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2])));
			
		}
	}

}
