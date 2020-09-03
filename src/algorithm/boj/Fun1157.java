package algorithm.boj;

import java.util.HashMap;
import java.util.Scanner;

public class Fun1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		str = str.toUpperCase();
		
		
		
		for(int i=0;i<str.length();i++) {
			map.put(String.valueOf(str.charAt(i)), 0);
		}
		
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(String.valueOf(str.charAt(i)))) {
				int cnt = map.get(String.valueOf(str.charAt(i)));
				map.put(String.valueOf(str.charAt(i)), ++cnt);
			}
		}
		
		int big=0;
        String bigkey="";
		
		for(String key : map.keySet()) {
			
			if(map.get(key)>big) {
				big = map.get(key);
                bigkey=key;
			} else if(map.get(key)==big) {
                bigkey="?";
            }
           
		}
		
		System.out.println(bigkey);
		
	}

}
