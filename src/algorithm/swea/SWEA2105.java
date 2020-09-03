package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SWEA2105 {

	static int N;
	static int[] dx = {0,1,1,-1,-1};
	static int[] dy = {0,-1,1,1,-1};
	static int[][] map;
	static boolean[][] visit;
	static boolean[] nVisited;
	static int result = Integer.MIN_VALUE;
	static String strCnt;
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("2105input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc= 0;tc<T;tc++) {
			N = sc.nextInt(); // 배열 범위
			
			map = new int[N][N];
			visit = new boolean[N][N];
			nVisited = new boolean[101];
			result=-1;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]= sc.nextInt();
				}
			}
			//================================
			//eat(map,0,0,0,1,cnt,1,"");
			
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map.length;j++) {
					visit[i][j]=true;
					//nVisited[map[i][j]] = true;
					eat(i, j, i, j, 1, 1," "+map[i][j]+" ");
					visit[i][j]=false;
					//nVisited[map[i][j]] = false;
				}
			}
			if(result<4)
				result = -1;
			
			System.out.println("#"+(tc+1)+" "+result);
			//System.out.println("===========================");
		}
	}
	
	public static void eat(int firstRow,int firstCol,int row,int col, int dir, int cnt, String menu) {
		//0. 변수 설명
//		int firstRow 	: 처음 시작점 행
//		int firstCol 	: 처음 시작점 열
//		int row			: 현재 행
//		int col			: 현재 열
//		int dir			: 방향 몇번 꺾었는지? - 4번꺾어야 사각형이 되니까 4번기준
//		int cnt			: 디저트 가게 들린 수
//		String menu		: 순서대로 들렸던 디저트 가게들의 디저트 수
		
		
		//System.out.println(menu);
		//System.out.println("{"+row+","+col+"} ,"+dir);
		
		//1. 종료조건	
		if(dir==4) {
			if(row+dx[dir] == firstRow && col+dy[dir] == firstCol) {
				result = Math.max(result, cnt);
				return;
			}
		}
		if(dir==5) return;
//		
//		if(row+dx[dir] == firstRow && col+dy[dir] == firstCol && cnt!=1) {
//			result = Math.max(result, cnt);
//			return;
//		}

		//2. 방향탐색
		int nx = row + dx[dir];
		int ny = col + dy[dir];

		
		//2-1. 배열의 범위 벗어났는지 체크
		if(nx >= N || ny >= N || nx < 0 || ny < 0) {
			//System.out.println("소멸");
			return;
		}
		
		//2-2. 이미 들렸던 곳인지 체크
		if(visit[nx][ny]){
			//System.out.println("소멸");
			return;
		}
		//2-3. 디저트의 개수가 같은 곳인지 체크
		if(menu.contains(String.valueOf(" "+map[nx][ny])+" ")){
		//if(nVisited[map[nx][ny]]){
			//System.out.println("소멸");
			return;
		}
	

		
		//System.out.println("+"+menu);
		visit[nx][ny]=true;
		//nVisited[map[nx][ny]] = true;
		//같은 방향으로 돌기
		eat(firstRow,firstCol,nx,ny,dir,cnt+1,menu+" "+map[nx][ny]+" ");
		//방향 꺾어서 돌기
		eat(firstRow,firstCol,nx,ny,dir+1,cnt+1,menu+" "+map[nx][ny]+" ");
		
		visit[nx][ny]=false; //false처리 이유: 함수를 돌다가 조건에 맞지 않아서 return으로 돌아왔을때, 이전 상황과 같이 만들어 주기 위함. visit배열은 공유하고 있기 때문에
		//nVisited[map[nx][ny]]=false;
	}

}
