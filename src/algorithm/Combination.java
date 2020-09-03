package algorithm;

public class Combination {

	static int[] num;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num = new int[] {0,1,2,3};
		int r = 2;
		int[] ans = new int[r];
		comb(ans ,0,r,0);
		
	}
	
	public static void comb(int[] ans, int idx, int r, int numidx) { //ans담을 배열, ans의 idx, 뽑을 숫자의 수, num배열의 idx
		if(r==0) { //r개의 수를 다 뽑았을 경우
			for(int i : ans) {
				System.out.print(i);
			}
			System.out.println();
		} else if(idx==ans.length || numidx==num.length){ //다 뽑진 않았지만 idx가 끝났거나 이미 존재하는 조합일 경우
			return;
		} else {
			ans[idx]=num[numidx];
			comb(ans,idx+1,r-1,numidx+1);//선택o - 선택하는 경우에는 ans의 idx와 num의 idx 모두 한칸씩 늘어난다. 뽑았으니 r도 1자리 줄어듦!
			comb(ans,idx,r,numidx+1);//선택x

		}
	}

}
