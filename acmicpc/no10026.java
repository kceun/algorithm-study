import java.util.*;

class Position {
	int row;
	int col;
	int isRgb;
	
	public Position (int r, int c ,int b) {
		this.row = r;
		this.col = c;
		this.isRgb = b;
	}
}
public class Main {

	public static int N, noRGB=0, yesRGB=0;
	public static char[][][] map;
	public static boolean[][][] visit;
	public static Queue<Position> q;
	public static int[] dx = {0,1,0,-1}; //동남서북 
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args)  {		
		
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new char[2][N][N];
		visit = new boolean[2][N][N];
		q = new LinkedList<Position>();
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[0][i][j] = str.charAt(j);
				map[1][i][j] = str.charAt(j);
				if(map[1][i][j] == 'G')
					map[1][i][j] = 'R';
					
			}
		}
		
		for (int k = 0; k < 2; k++) {
			visit = new boolean[2][N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 무슨 색깔인지 받기
					char color = map[k][i][j];
					
					//0.방문하지 않은 곳이면서
					if(!visit[k][i][j]) {
				
						//1. 적록색약이 아닐 경우
						if(k==0)
							yesRGB++;
						else if(k==1)
							noRGB++;
						
						q.add(new Position(i, j, k));
						bfs(color);	
					}
				}
			}			
		}
		
		
		System.out.println(yesRGB+" "+noRGB);
		
		
	}
	// 지정된 색깔의 한 영역 다 돌기 (ex. R이면 red구역 다 visit true 처리)
	public static void bfs(char color) {
		
		
		while(!q.isEmpty()) {
			
			Position pos = q.poll();
			visit[pos.isRgb][pos.row][pos.col] = true;
			
			//1.방향 탐색
			for (int i = 0; i < dx.length; i++) {
				
				int nx = pos.row + dx[i];
				int ny = pos.col + dy[i];
				
				
				//2.종료조건
				//2-1.배열 범위 벗어나는가?
				if(nx >= N || ny >= N || nx < 0 || ny < 0)
					continue;
				
				//2-2.다른 문자가 나왔는가?
				if(map[pos.isRgb][nx][ny]!=color)
					continue;
				
				//2-3.방문 했던 곳인가?
				if(visit[pos.isRgb][nx][ny])
					continue;
				
				
				visit[pos.isRgb][nx][ny] = true;
				
				q.add(new Position(nx, ny, pos.isRgb));

			}
			
		}

	}


}
