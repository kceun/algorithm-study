package algorithm;

import java.util.*;
public class Powerset {

	static int[] num;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		num = new int[]{5,2,6};
		int[] ans = new int[num.length];

		powerset(ans,0);
		
	}

	public static void powerset(int[] ans, int idx) { //ans은 visit여부를 파악하기 위함
		if(idx==num.length) {
			for(int i=0;i<ans.length;i++) {
				if(ans[i]==1)
					System.out.print(num[i]);
			}
			System.out.println(); //공집합은 여기서 걍 라인줄바꿈 되는 것,,
		} else {
			//해당 인덱스 선택x
			ans[idx] = 0;
			powerset(ans,idx+1);
			
			//해당 인덱스 선택o
			ans[idx] = 1;
			powerset(ans,idx+1);
		}
	}
}
