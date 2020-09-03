package algorithm.swea;
import java.io.*;
import java.util.*;

class Home {
	int loc;
	boolean seeYN = false;
	
	public Home(int loc) {
		this.loc=loc;
	}
}

public class SWEA1206 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("1206input.txt"));
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
