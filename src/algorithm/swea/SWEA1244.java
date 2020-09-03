package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SWEA1244 {
	static boolean[][] visit;
	static int C;
	static int result;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("1244input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			String str = sc.next();
			C = sc.nextInt(); //교환횟수
			int[] arr = new int[str.length()];
			visit = new boolean[C+1][1000000];
			result=0;
			for(int i=0;i<str.length();i++) {
				arr[i]=Character.getNumericValue(str.charAt(i));
			}

			dfs(arr,0);
			
			System.out.println("#"+(tc+1)+" "+result);
		}
	}
	
	public static void dfs(int[] arr, int cnt) {
		
		String str="";
		if(C==cnt) {
			str= intArrToSTring(arr);
			result = result < Integer.valueOf(str) ? Integer.valueOf(str) : result;
			//return;
		}
		else {
			for(int i=0;i<arr.length-1;i++) {
				for(int j=i+1;j<arr.length;j++) {
					
					//바꾸기
					int[] arrCopy = arr.clone();
					int temp = arrCopy[i];
					arrCopy[i] = arrCopy[j];
					arrCopy[j] = temp;
					str= intArrToSTring(arrCopy);
					if(!visit[cnt][Integer.valueOf(str)]) {
						visit[cnt][Integer.valueOf(str)]=true;
						dfs(arrCopy,cnt+1);
					}
					
				}
			}
		}
	}
	
	public static String intArrToSTring(int[] arr) {
		String str="";
		for(int i:arr) {
			str+=i;
		}
		
		return str;
	}

}
