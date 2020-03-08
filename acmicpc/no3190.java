import java.io.*;
import java.util.*;

public class Main {

	public static int N,K,L, dir=1, time=0; //dir 처음에는 오른쪽으로 가기때문에 방향을 1로 줌
	public static int row = 1,col=1;
	public static int[][] map;
	public static Queue<Integer[]> snake = new LinkedList<>();
	public static Queue<String[]> q = new LinkedList<>();
	public static StringTokenizer st;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		
		//사과 배치하기
		for (int i = 0; i < K; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 2; //사과는 2;
		}
		
		//뱀의 방향 전환 횟수
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			String transTime = st.nextToken();
			String transDir = st.nextToken();
			
			q.add(new String[]{transTime , transDir});
			
		}
		
		//뱀 시작
		dfs();
		System.out.println(time);

	}
	
	public static void dfs() {
		
		map[row][col]=1; //시작점의 뱀
		snake.add(new Integer[] {row,col});
		
		while(true) {

			time++;
			
			//이동할 위치 조정
			int nx = row + dx[dir];
			int ny = col + dy[dir];
			
			//범위 벗어나냐?
			if(nx < 1 || ny < 1 || nx >= N+1 || ny >= N+1)
				return;
			//뱀 자기자신의 몸에 부딪히냐?
			if(map[nx][ny]==1)
				return;

			
			snake.add(new Integer[] {nx,ny});
			//사과가 없으면 꼬리 위치한 칸 비워주기
			if(map[nx][ny]!=2) {
				map[snake.peek()[0]][snake.peek()[1]]=0;
				snake.poll();
			}

			map[nx][ny]=1;
			row = nx;
			col = ny;
			
			//이동해야하는 시간인가?
			String[] sArr = q.peek();
			
			if(!q.isEmpty() && time==Integer.parseInt(sArr[0])) {
				q.poll(); //제거
				
				if(sArr[1].equals("L")) //왼쪽90도
					dir = (dir-1 < 0 ? dx.length-1 : dir-1);
				else if(sArr[1].equals("D")) //오른쪽90도
					dir = (dir+1 >= dx.length ? 0 : dir+1);
				
			}
			
			//print();
		}
	}

	public static void print() {
		System.out.println("================");
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
