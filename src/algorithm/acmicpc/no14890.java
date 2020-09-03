package algorithm.acmicpc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class no14890 {

	public static int N, L, res = 0;
	public static int[][] map;

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		// data 넣기
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			solve(i, 0, true);
			solve(0, i, false);
		}

		System.out.println(res);

	}

	public static void solve(int x, int y, boolean isRow) {

		// 지금 숫자
		int road[] = new int[N];
		boolean visit[] = new boolean[N]; // 경사로 놓은자리인지..
		
		for (int i = 0; i < N; i++) {
			road[i] = isRow ? map[x][y + i] : map[x + i][y];
		}

		for (int i = 1; i < N; i++) {

			// 높이가 같은가?
			if (road[i] == road[i - 1])
				continue;

			// 높이 차이가 1만 나는가?
			if (Math.abs(road[i] - road[i - 1]) == 1) {

				// 내려가야 하는 상황인가?
				if (road[i] < road[i - 1]) {
					
					//경사로 놓기
					//1. 전체 범위를 벗어나지 않으면서 경사로 길이 L 만큼 놓을 자리가 있는가?
					//2. 경사로 길이 L 만큼 road의 높이는 동일한가?
					//3. 이미 경사로가 놓여있지는 않은가?
					for (int j = i; j < i+L; j++) {
						if(j<N && road[j]==road[i] &&!visit[j])
							visit[j]=true;
						else
							return;
					}

				}
				// 올라가야 하는 상황인가?
				if (road[i] > road[i - 1]) {
					
					//경사로 놓기
					//1. 전체 범위를 벗어나지 않으면서 경사로 길이 L 만큼 놓을 자리가 있는가?
					//2. 경사로 길이 L 만큼 road의 높이는 동일한가?
					//3. 이미 경사로가 놓여있지는 않은가?
					for (int j = i-1; j > i-1-L; j--) {
						if(j>=0 && road[j]==road[i-1] &&!visit[j])
							visit[j]=true;
						else
							return;
					}

				}
			}
			//높이차이가 1보다 더 많이 나는가?
			else
				return;

		}

		res++;


	}

}
