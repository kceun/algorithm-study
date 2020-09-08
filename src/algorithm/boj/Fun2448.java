package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Fun2448 {

	public static Character[][] map;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		map = new Character[N][N * 2 - 1]; // 3일때 3*5 행렬이 만들어짐
		for (int i = 0; i < N; i++) {

			Arrays.fill(map[i], ' '); // 배열 내부 모두 공백문자으로 초기화 세팅

		}

		// solve
		solve(0, N - 1, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2 - 1; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	public static void solve(int row, int col, int n) {

		// 패턴의 가장 작은 단위인가? n==3
		if (n == 3) {
			// 별 출력
			map[row][col] = '*';
			map[row+1][col+1] = map[row+1][col-1] = '*';
			map[row+2][col-2] = map[row+2][col-1] = map[row+2][col] = map[row+2][col+1] = map[row+2][col+2] = '*';
		} else {

			// 아니라면, 더 작은 단위로 쪼개주기
			int cut = n / 2;
			// 그리고 그 단위의 가장 꼭대기 * 좌표로 solve 재귀 호출하기
			solve(row, col, cut);
			solve(row + (n / 2), col + (n / 2), cut);
			solve(row + (n / 2), col - (n / 2), cut);
		}
	}

}
