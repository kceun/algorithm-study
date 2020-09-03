package algorithm;
import java.io.FileInputStream;
import java.util.Scanner;


	
	class Persons{
		int row,col,cnt = 0;
		
		public Persons(int row, int col, int cnt){
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	class Trap{
		int row;
		int col;
		public Trap(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	public class IssacTest {
		
	private static final int[] dx = {0,0,1,0,-1}; //동남서북 
	private static final int[] dy = {0,1,0,-1,0}; //동남서북 	
	private static String map[][];
	
	private static int money = 0;
	
	public static void main(String[] args ) throws Exception{
	System.setIn(new FileInputStream("solution32.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			money = 0;
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int N = sc.nextInt();
			//맵정보 저장
			map = new String[X][Y];
			for (int i = 0; i < X; i++) { 
				for (int j = 0; j < Y; j++) { 
					map[i][j] = sc.next();
				}
			}
			//사람 정보 저장
			Persons PersonInfo[] = new Persons[N];
			for (int i = 0; i < N; i++) { 
				int row = sc.nextInt() -1;
				int col = sc.nextInt() -1;
				int cnt = sc.nextInt();
				Persons person = new Persons(row,col,cnt);
				PersonInfo[i] = person;
			}
			//트랩 정보 저장
			int trapNum = sc.nextInt();
			Trap trap[] = new Trap[trapNum];
			for (int i = 0; i < trapNum; i++) {
				int row = sc.nextInt() -1;
				int col = sc.nextInt() -1;
				Trap tr = new Trap(row,col);
				trap[i]=tr;
			}
		
			//사람수만큼 돌면서 게임 진행
			loop :for (int i = 0; i < PersonInfo.length; i++) {
				money-=1000; // 참가비 지불

				int cnt = PersonInfo[i].cnt; //점프 횟수

				while(cnt > 0) { //점프 횟수 동안 실행
					
					int dir = map[PersonInfo[i].row][PersonInfo[i].col].charAt(0) -'0'; //방향계산
					int jump = map[PersonInfo[i].row][PersonInfo[i].col].charAt(1) -'0'; //점프칸수
					
					int nx = PersonInfo[i].row + dx[dir]*jump; //2번 1씩 내려감.
					int ny = PersonInfo[i].col + dy[dir]*jump; //0
					if(nx < 0 || nx >=X || ny < 0 || ny >=Y) { //선을 넘을 경우
						continue loop;
					}else {
						for (int j = 0; j < trap.length; j++) {
							if(trap[j].row == nx && trap[j].col == ny) { //트랩이면 폭발
								continue loop;
							}
						}
					}
					//문제없는 경우 자기 좌표 저장
					PersonInfo[i].row = nx;
					PersonInfo[i].col = ny;

					cnt--;
				}
		
				money += Integer.parseInt(map[PersonInfo[i].row][PersonInfo[i].col]) * 100;

			}

			System.out.println("#" + tc + " "+ money);
		}
	}
}
