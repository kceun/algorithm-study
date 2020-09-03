package algorithm.boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Fun9933 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Character middleWord= ' ';
		int wordLength = 0;
		String allWord= "";
		Scanner sc = new Scanner(System.in);
		int tc= Integer.parseInt(sc.nextLine());
		String[] arr = new String[tc];
		for(int i=0;i<tc;i++) {
			arr[i] = sc.nextLine();
			allWord+=" "+arr[i];
		}
		
		for(int i=0;i<arr.length;i++) {
			String reverse = "";
			for(int j = arr[i].length()-1;j>=0;j--) {
				reverse +=arr[i].charAt(j);
			}
			// System.out.println(reverse); debug 용도
			if(allWord.contains(reverse)) {
				wordLength = reverse.length();
				middleWord = reverse.charAt(wordLength/2);
				
			}
			
		}
		
		System.out.println(wordLength+ " " + middleWord);
		
	}

}
