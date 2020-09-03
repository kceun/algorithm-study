package algorithm;

public class StringPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "문자열을 공부해봅시다. 화이팅!";
		String str2 = "abcdef";
		
		String str3 = "chocolate#cake#MACARON";
		String str4 = "ILoveYoU";
		
		System.out.println(str1.charAt(2)); //열
		System.out.println(str2.charAt(0)); //a
		int n =2;
		int n2=3;
		

		/*		
		String str5 = "abcd"; 
		String str6 = "c"; 

		System.out.println(str5.contains(str6));
	
		String str5 = "A";
		String str6 = "a";
		String str7 = "b";
		String str8 = "e";
		String str9 = "e";
		
		
		System.out.println(str6.compareTo(str7)); //-1
		System.out.println(str5.compareTo(str6)); //-32
		System.out.println(str8.compareTo(str9)); //0
		System.out.println(str6.compareTo(str8)); //-4
		System.out.println(str8.compareTo(str6)); //4
				
		System.out.println(str5.trim()); //H e llo	
	
		String[] sp = str3.split("#");
		for(int i=0;i<sp.length;i++) {
			System.out.println(sp[i]);
		}
		
		System.out.println(str3.replace("#", "%%"));		
	
		System.out.println(str4.length());
		System.out.println(str1.length());
		
		System.out.println(str4.endsWith("U")); //true
		System.out.println(str4.endsWith("u")); //false
		System.out.println(str4.endsWith("a")); //false
	
		System.out.println(str1.startsWith("문")); //true
		System.out.println(str1.startsWith("공")); //false
		System.out.println(str2.startsWith("a")); //ture
		
		System.out.println(str1.concat(str4)); //문자열을 공부해봅시다. 화이팅!ILoveYoU
		System.out.println(str1+str4);

		System.out.println(str1.toUpperCase()); // 문자열을 공부해봅시다. 화이팅!
		System.out.println(str2.toUpperCase()); // ABCDEF
		System.out.println(str4.toLowerCase()); // iloveyou
		System.out.println(str4.toUpperCase()); // ILOVEYOU

		System.out.println(str1.substring(5));
		System.out.println(str1.substring(5, 8));
		
		
		System.out.println(str1.replaceAll("문자열","자료구조들")); 			//자료구조들을 공부해봅시다. 화이팅!
		System.out.println(str3.replaceAll("chocolate", "strawberry")); //strawberry#cake#macaron
		
		System.out.println(str1.indexOf("공부"));		//5
		System.out.println(str2.indexOf("b"));		//1
		
		
		*/
		//fun1();
		
	}
	
	public static void fun1() {
		
		String a = "CHOCOLATE";
		String b = a;
		String c = "CHOCOLATE";
		String d = new String("CHOCOLATE");
		String e = "PASTA";
		
		System.out.println(a==b);			//true
		System.out.println(a.equals(b));	//true
		
		System.out.println(a==c);			//true
		System.out.println(a.equals(c));	//true
		
		System.out.println(b==c);			//true
		System.out.println(b.equals(c));	//true
		
		System.out.println(a==d);			//false
		System.out.println(a.equals(d));	//true
				
		System.out.println(a==e);			//false
		System.out.println(a.equals(e));	//false
	}

}
