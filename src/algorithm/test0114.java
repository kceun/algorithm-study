package algorithm;

public class test0114 {

	    public boolean test(int i){

	        try {

	              System.out.println("i : " + i);

	              if(i == 1)

	                     throw new Exception();

	              return true;

	             }

	        catch (Exception e) {

	              System.out.println("exception");

	                    return false;

	             }

	             finally{

	                    System.out.println("finally");

	             }

	    }

	 

	    public static void main(String args[]) throws InterruptedException {

	    	test0114 java = new test0114();

	        java.test(0);

	        System.out.println("==========================================");

	        java.test(1);

	    }


	//출처: http://obanadingyo.tistory.com/entry/JAVA-exception-return-문이-있는-try-catch-finally [Right now]
}
