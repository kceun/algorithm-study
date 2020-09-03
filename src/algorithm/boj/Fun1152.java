package algorithm.boj;

import java.util.Scanner;

public class Fun1152 {

	 public static void main(String[] args) {
	        
	        Scanner sc = new Scanner(System.in);
	        String str = sc.nextLine();
	        str = str.trim();
	        
	        String[] sp = str.split(" ");
	        
	        if(sp==null)
	        	System.out.println(0);
	        else
	        	System.out.println(sp.length);
	        
	    }

}
