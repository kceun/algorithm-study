package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Fun17144 {

	public static int R, C, T, idx = 0, res = 0;
	public static int[][] map;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] air = new int[2]; // 공기청정기 위치 (늘 1열에 있다.)
	public static int[][] nmap; // 확산되어서 넘어간 미세먼지인가?

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();

				// 공기청정기 위치 저장
				if (map[i][j] == -1)
					air[idx++] = i;
			}
		}

		for (int t = 0; t < T; t++) {

			nmap = new int[R][C];

			// 1. 한칸씩 전체이동하며 미세먼지 확산
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						dfs(i, j);
					}

				}
			}

			spreadCopy(); // 확산 된 애들과 원래 애들 합쳐주기
			
			// 2. 공기청정기 가동 하기
			// 위쪽 공기청정기
			// 한칸씩 이동
			int airx = air[0];
			int airy = 0;
			int width = R;
			int height = air[0];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(0);
			// 가로이동
			for (int i = 0; i < width; i++) {
				airy++;
				q.add(map[airx][airy]);
				map[airx][airy] = q.poll();
			}
			width--;

			// 세로이동
			for (int i = 0; i < height; i++) {

				q.add(map[--airx][airy]);
				map[airx][airy] = q.poll();
			}
			height--;

			// 가로이동
			for (int i = 0; i < width; i++) {
				q.add(map[airx][--airy]);
				map[airx][airy] = q.poll();
			}

			// 세로이동
			for (int i = 0; i < height; i++) {

				q.add(map[++airx][airy]);
				map[airx][airy] = q.poll();
			}

			// 아래쪽 공기청정기
			// 한칸씩 이동
			int airxDown = air[1];
			int airyDown = 0;
			int widthDown = R;// - 1;
			int heightDown = air[1];// - 1;
			Queue<Integer> qDown = new LinkedList<Integer>();
			qDown.add(0);
			// 가로이동
			for (int i = 0; i < widthDown; i++) {
				airyDown++;
				qDown.add(map[airxDown][airyDown]);
				map[airxDown][airyDown] = qDown.poll();
			}
			//widthDown--;

			// 세로이동
			for (int i = 0; i < heightDown; i++) {

				qDown.add(map[++airxDown][airyDown]);
				map[airxDown][airyDown] = qDown.poll();
			}
			heightDown--;

			// 가로이동
			for (int i = 0; i < widthDown; i++) {
				qDown.add(map[airxDown][--airyDown]);
				map[airxDown][airyDown] = qDown.poll();
			}

			// 세로이동
			for (int i = 0; i < heightDown; i++) {

				qDown.add(map[--airxDown][airyDown]);
				map[airxDown][airyDown] = qDown.poll();
			}


		}

		// 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				//System.out.print("\t" + map[i][j]);
				 if (map[i][j] > 0)
					 res += map[i][j];
			}
			//System.out.println();
		}

		System.out.println(res);

	}

	public static void dfs(int x, int y) {

		// 미세먼지 확산
		// 확산하기
		int cnt = 0;
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위를 벗어나는가?
			if (nx >= R || nx < 0 || ny >= C || ny < 0)
				continue;

			// 공기청정기가 있는가?
			if (map[nx][ny] == -1)
				continue;

			// // 이미 미세먼지가 있는가?
			// if (map[nx][ny] > 0)
			// continue;

			nmap[nx][ny] = nmap[nx][ny] + (map[x][y] / 5); // 확산된 애들 표시
			cnt++;
		}
		map[x][y] = map[x][y] - (map[x][y] / 5) * cnt;

	}

	public static void spreadCopy() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += nmap[i][j];
			}
		}
	}

}
