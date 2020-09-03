package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA1216 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("1216input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=0;tc<10;tc++) {
			int t = sc.nextInt();
			char map[][] = new char[100][100];
			int ans = 0;
			
			for(int i=0;i<100;i++) {
				String str= sc.next();
				for(int j=0;j<100;j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			// s 	: 회문 길이 - 가장 긴 회문의 길이 수부터 검색
			//cnt 	: 실제 회문 길이 +1 (배열은 인덱스가 99까지니까)
			// i	: x좌표
			// j	: y좌표
			// k 	: 기준 좌표당 회문 길이 돌 수 있도록 조절해주는 수 (ex 0.0일때 99길이의 회문이 일치하는지 조절해줌)
			//가로
			for(int s=99;s>0;s--) { // 99부터 좁히기 
				int cnt = s+1;
				for(int i=0;i<100;i++) {
					for(int j=0;j<100;j++) {
						boolean flag = false;
						for(int k=0;k<cnt/2;k++) { // cnt의 절반만 돌면 됨 0-7,1-6,2-5,3-4가 끝인것처럼
							if((j+k)>=100 || (j+s-k)>=100) { //배열초과시 true로 바꿔주고 반복문 빠져나감
								flag=true;
								break;
							}
							if(map[i][j+k]!=map[i][j+s-k]) { //같은 알파벳인지 확인 + j의 위치에따라 변경
								flag=true;
							}
						}
						if(!flag) {
							if(ans<cnt)
								ans=cnt;
						}
					}
				}
			}
			
			//세로
			for(int s=99;s>0;s--) { // 99부터 좁히기
				int cnt = s+1;
				for(int i=0;i<100;i++) {
					for(int j=0;j<100;j++) {
						boolean flag = false;
						for(int k=0;k<cnt/2;k++) {
							if((j+k)>=100 || (j+s-k)>=100){
								flag=true;
								break;
							}
							if(map[j+k][i]!=map[j+s-k][i]) {
								flag=true;
							}
						}
						if(!flag) {
							if(ans<cnt)
								ans=cnt;
						}
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}

}
