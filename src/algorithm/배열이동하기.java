package algorithm;

import java.util.*;

public class 배열이동하기 {

	static int[][] map = new int[3][3];

	public static void main(String[] args) {

		int[] arr = { 3, 2, 4, 1, 6, 7, 5, 2, 0 };

		int num = 0;
		// 배치
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = arr[num++];
			}
		}

		print();

		for (int T = 0; T < 2; T++) {
			// 한칸씩 이동
			int x = 2;
			int y = 0 - 1;
			int cnt = 0;
			int width = 3;
			int height = 3 - 1;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(0);
			// 가로이동
			for (int i = 0; i < width; i++) {
				y++;
				q.add(map[x][y]);
				map[x][y] = q.poll();
			}
			width--;

			// 세로이동
			for (int i = 0; i < height; i++) {

				q.add(map[--x][y]);
				map[x][y] = q.poll();
			}
			height--;

			// 가로이동
			for (int i = 0; i < width; i++) {
				q.add(map[x][--y]);
				map[x][y] = q.poll();
			}

			// 세로이동
			for (int i = 0; i < height; i++) {

				q.add(map[++x][y]);
				map[x][y] = q.poll();
			}
		}

		System.out.println("========");
		print();



	}

	public static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void move() {
		for (int T = 0; T < 2; T++) {
			// 한칸씩 이동
			int x = 2;
			int y = 0 - 1;
			int cnt = 0;
			int width = 3;
			int height = 3 - 1;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(map[x - 1][0]);
			// 가로이동
			for (int i = 0; i < width; i++) {
				y++;
				q.add(map[x][y]);
				map[x][y] = q.poll();
			}
			width--;

			// 세로이동
			for (int i = 0; i < height; i++) {

				q.add(map[--x][y]);
				map[x][y] = q.poll();
			}
			height--;

			// 가로이동
			for (int i = 0; i < width; i++) {
				q.add(map[x][--y]);
				map[x][y] = q.poll();
			}

			// 세로이동
			for (int i = 0; i < height; i++) {

				q.add(map[++x][y]);
				map[x][y] = q.poll();
			}
		}

		System.out.println("========");
		print();
	}
}
