package algorithm;

public class test {
	
	static int map[][] = new int[3][3];
	static int ans[][] = new int[3][3];
	public static void main(String[] args) {

		int num =1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = num++;
			}
		}
		
		
		print(map);
		
	
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				ans[i][j] = map[2-j][i];
			}
		}
		map =ans;
		print(ans);
		print(map);
		
	}
	public static void print(int[][] m) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void fun(String str)
	{
		str="머지";
		System.out.println(str);
	}
}
