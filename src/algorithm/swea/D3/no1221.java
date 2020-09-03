package algorithm.swea.D3;

import java.util.*;
import java.io.FileInputStream;

class Days {
	int idx;
	String day;
	
	public Days(int idx, String day) {
		this.idx= idx;
		this.day=day;
	}
}
class no1221
{
    public static String[] dayStr = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	public static HashMap<String,Integer> map;
	public static ArrayList<Days> ans;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		map = new HashMap<String,Integer>();
		//요일별 인덱스 세팅
		for (int k = 0; k < dayStr.length; k++) {
			map.put(dayStr[k], k);
		}
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			ans = new ArrayList<Days>();
			sc.next(); //#1들어오는 거 무시
			int N = sc.nextInt();

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				ans.add(new Days(map.get(str),str)); //map에다가 새로 받은 str넣어서 인덱스 가져오기
			}
			
			
			//Collections.sort
			//인덱스 기준으로 정렬하기 오름차순
			Comparator<Days> cp = new Comparator<Days>() {
				@Override
				public int compare(Days d1, Days d2) {
					if(d1.idx>d2.idx)
						return 1;
					else if(d1.idx==d2.idx)
						return 0;
					else
						return -1;
				}
			};
			
			Collections.sort(ans,cp);
			
			System.out.print("#"+(tc+1)+" ");
			for(Days d : ans) {
				System.out.print(d.day+" ");
			}
			System.out.println();

		}
	}
}
