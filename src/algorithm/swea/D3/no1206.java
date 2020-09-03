package algorithm.swea.D3;

import java.util.Arrays;
import java.util.Scanner;

class Home {
	int loc;
	boolean seeYN = false;
	
	public Home(int loc) {
		this.loc=loc;
	}
}

class no1206
{
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);

		for(int n = 0;n<10;n++) {
			int num =0;
			int t = sc.nextInt(); //tc
			Home[] map = new Home[t];
			for(int tc=0;tc<t;tc++) {
				map[tc]= new Home(sc.nextInt());
			}
			for(int i=2;i<map.length-2;i++) {
				if(map[i].loc>map[i+1].loc
						&& map[i].loc>map[i+2].loc 
						&& map[i].loc>map[i-1].loc 
						&& map[i].loc>map[i-2].loc) {
					map[i].seeYN = true;
					int[] compare = {map[i+1].loc,map[i-1].loc,map[i+2].loc,map[i-2].loc};
					Arrays.sort(compare);
					num+= map[i].loc-compare[compare.length-1];
				}
			}
			System.out.println("#"+(n+1)+" "+num);
		}
	}
}
