package algorithm.swea.D3;

import java.util.Scanner;
import java.io.FileInputStream;

class no1244
{
	static boolean[][] visit;
	static int C;
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("1244input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			String str = sc.next();
			C = sc.nextInt(); //교환횟수
			int[] arr = new int[str.length()];
			visit = new boolean[C+1][1000000]; // 교환횟수에 해당하는 숫자 방문 여부확인
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
					int[] arrCopy = arr.clone(); //새로 메모리 할당하지 않고 원본을 계속 swap하다보면 그다음번째 숫자들에게 지장이 간다...
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
