package algorithm;

public class StarPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fun1();
	}

	public static void fun1() {
		//마름모
		int n = 4;
		
		for(int i=1;i<=n;i++) {
			for(int j=n;j>i;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<i*2-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<n-i;j++) {
				System.out.print(" ");
			}
			for(int j=i*2-1;j>0;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
//		for(int i=0;i<n;i++) {
//			
//			for(int j=0;j<i;j++) {
//				System.out.print(" ");
//			}
//			for(int j=i;j<n;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
	}
}
