package algorithm;

public class CLASSTEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Food f = new Food();
		Food f1 = new Pork();
		Pork p = new Pork();
		
		//Pork p2 = (Pork)new Food();
		
		
		
	}

}

abstract class Food {
	
	abstract public void run();
	
}

class Pork extends Food {
	
	public void pork() {}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
interface Cow {
	public void umm();
}
class Beef implements Cow {
	public void beef() {}

	@Override
	public void umm() {
		// TODO Auto-generated method stub
		
	}


}