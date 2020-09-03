package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Fun9935 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Fun9935.txt"));
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String bomb = sc.next();
		
		while(str.contains(bomb)) {
			str = str.replace(bomb, "");
		}
		
		if(str.length()==0)
			System.out.println("FRULA");
		else
			System.out.println(str);
		
		

	}

}
