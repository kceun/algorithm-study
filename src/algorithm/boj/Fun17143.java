package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Fun17143 {

	public static int R, C, M, res = 0;
	public static Shark[][] map;
	public static Shark[][] nmap; // 초당 이동한 상어의 위치 나타내기
	public static HashMap<Integer, Integer[]> direct = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();

		// 방향정보 넣기
		direct.put(1, new Integer[] { -1, 0 }); // 위
		direct.put(2, new Integer[] { 1, 0 }); // 아래
		direct.put(3, new Integer[] { 0, 1 }); // 오른쪽
		direct.put(4, new Integer[] { 0, -1 }); // 왼쪽

		map = new Shark[R][C];

		// 상어 정보 넣기
		for (int i = 0; i < M; i++) {
			//0부터 시작하기 위하여 -1해줌
			map[sc.nextInt()-1][sc.nextInt()-1] = new Shark(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		// 낚시왕 출동 (총 col 갯수만큼 오른쪽으로 이동)
		for (int king = 0; king < C; king++) {

			// 상어 잡기
			for (int i = 0; i < R; i++) {
				if (map[i][king] != null) {
					Shark shk = map[i][king];
					res += shk.size;
					map[i][king] = null;
					break;
				}
			}

			// 상어 이동
			nmap = new Shark[R][C];

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != null)
						dfs(i, j, map[i][j], map[i][j].speed);
				}
			}
			
			sharkCopy();

		}
		
		System.out.println(res);
	}

	public static void dfs(int x, int y, Shark shk, int cnt) {

		// 종료조건 - 속력만큼 다 이동했는가?
		if (cnt == 0) {
			if (nmap[x][y] != null) {
				// 이미 상어가 존재하면 크기가 큰 상어가 잡아먹는다.
				nmap[x][y] = shk.size > nmap[x][y].size ? shk : nmap[x][y];
			}
			else
				nmap[x][y] = shk;
			
			return;
		}
		
		// 방향대로 이동하기
		int nx = x+ direct.get(shk.dir)[0];
		int ny = y+ direct.get(shk.dir)[1];
		
		// 범위를 벗어났는가?
		if( nx>= R || nx < 0 || ny >= C || ny < 0) {
			//방향 바꿔주기
			shk.dir = transDir(shk.dir);
			nx = x+ direct.get(shk.dir)[0];
			ny = y+ direct.get(shk.dir)[1];
		}
		
		dfs(nx,ny,shk,cnt-1);

	}

	public static int transDir(int dir) {
		
		switch(dir) {
		case 1: return 2;
		case 2: return 1;
		case 3: return 4;
		case 4: return 3;
		}		
		return 0;
	}
	
	public static void sharkCopy() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = nmap[i][j];
			}
		}
	}
}

class Shark {

	int dir;
	int speed;
	int size;

	public Shark(int s, int d, int z) {

		this.speed = s;
		this.dir = d;
		this.size = z;
	}
}
