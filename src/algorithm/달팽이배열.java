package algorithm;

public class 달팽이배열 {

	public static void main(String[] args) {
		
		int R = 5, C = 7;
		int[][] map = new int[R][C];
		int num = 1;

		int x = 0;
		int y = -1;
		int flag = 1;
		int width = C;
		int height = R-1;
		while(num<=(R*C)) {
			
			//가로 이동
			for (int i = 0; i < width && num<=(R*C); i++) {
				//y+=flag;
				map[x][++y]=num++;
			}
			width--; 
			
			//세로 이동
			for (int i = 0; i < height && num<=(R*C); i++) {
				//x+=flag;
				map[++x][y]=num++;
			}
			height--;
			
			//가로 이동
			for (int i = 0; i < width && num<=(R*C); i++) {
				//y+=flag;
				map[x][--y]=num++;
			}
			width--;
			
			//세로 이동
			for (int i = 0; i < height && num<=(R*C); i++) {
				//x+=flag;
				map[--x][y]=num++;
			}
			height--;
			
			//flag*=(-1);
		}
		
		
		
		//프린트
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		//fun();
		
	}
	
	public static void fun() {
		 int length = 4;
		  int output = length;
		  int[][] array = new int[length][length];
		  int SW = 1;
		  int i = 0, j = -1;
		  int k = 1;
		  
		  while(true){
		   
		   for(int c = 0 ; c < length ; c++){
		    j = j+SW;
		    array[i][j] = k;
		    k = k + 1;
		   }
		   
		   length = length - 1;
		   if(length == 0)
		    break;
		   
		   for(int c = 0 ; c < length ; c++){
		    i = i+SW;
		    array[i][j] = k;
		    k = k + 1;
		   }
		   
		   SW = SW * (-1);
		  }
		  
		  for(i = 0 ; i < output ; i++){
		   for(j = 0 ; j < output ; j++){
		    System.out.printf("%2d ", array[i][j]);
		   }
		   System.out.println();
		  }
	}

}
