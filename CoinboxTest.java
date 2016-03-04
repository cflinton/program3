public class CoinboxTest {
	public static void main(String[] args) {
		System.out.println("Testing constructor");
		Coinbox cb = new Coinbox(3, 4, 5);
		System.out.println("Testing displayCoins");
		cb.displayCoins();
		System.out.println("Testing getAmount, and testing option for a Quarter");
		if(cb.option('Q')){
			System.out.println("Option returned true");	
		} else {
			System.out.println("Option returned false");
		}

		System.out.println("Testing option for a Dime");
		if(cb.option('D')){
			System.out.println("Option returned true");	
		} else {
			System.out.println("Option returned false");
		}

		System.out.println("Testing option for a Nickel");
		if(cb.option('N')){
			System.out.println("Option returned true");	
		} else {
			System.out.println("Option returned false");
		}
		
		System.out.println("Testing option for a random letter");
		if(cb.option('Z')){
			System.out.println("Option returned true");	
		} else {
			System.out.println("Option returned false");
		}

		System.out.println("Testing option for Return");
		if(cb.option('R')){
			System.out.println("Option returned true");	
		} else {
			System.out.println("Option returned false");
		}
		
		System.out.println("Testing giveChange for 5");
		cb.giveChange(5);

		System.out.println("Testing giveChange for 10");
		cb.giveChange(10);
		
		System.out.println("Testing giveChange for 25");
		cb.giveChange(25);

		System.out.println("Testing giveChange for 15");
		cb.giveChange(15);

		System.out.println("Testing giveChange for 35");
		cb.giveChange(35);

		System.out.println("Testing giveChange for 30");
		cb.giveChange(30);

		System.out.println("Testing giveChange for 20");
		cb.giveChange(20);

	}
}
