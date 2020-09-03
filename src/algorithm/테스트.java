package algorithm;

public class 테스트 {

	public static void main(String[] args) {

		int R = 3, C = 7;
		int[][] map = new int[R][C];
		int num = 1;

		int x = 0;
		int y = 0;
		for (int i = 1; i <= 1; i++) {

			//switch (i) {
			//case 1: {
				for (int j = 1; j < C; j++) {
					map[x][y++] = num++;
				}
			//}
			//	break;
				
			//case 2 : {
				for (int j = 1; j < R; j++) {
					map[x++][y]=num++;
				}
			//} break;
			
			//case 3 : {
				for (int j = 1; j < C; j++) {
					map[x][y--]=num++;
				}
			//}
			//break;
			
			//case 4 : {
				for (int j = 1; j < R; j++) {
					map[x--][y]=num++;
				}
			//}

			//}

		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
