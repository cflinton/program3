public class Coinbox {
	private int numQ, numD, numN;
	private int amount;

	public Coinbox(int Q, int D, int N) {
		numQ = Q;
		numD = D;
		numN = N;
		amount = 0;
	}
	
	public void giveChange(int change) {
		if(change > 0){
			while((change >= 25) && (numQ > 0)){
				numQ--;
				change = change - 25;
			}
			while((change >= 10) && (numD > 0)){
				numD--;
				change = change - 10;
			}
			while((change >= 5) && (numN > 0)){
				numN--;
				change = change - 5;
			}
		amount = 0;
		System.out.println("You have " + numQ + " quarters, " + numD + " dimes, and " + numN + " nickels in your box.");
		}
	}
	
	public void displayCoins() {
		displayAmount();
		System.out.println("You can deposit a (Q)uarter, a (D)ime, or a (N)ickel, or you can (R)eturn the money you deposited this session.");
	}
	
	public int getAmount(){
		return amount;
	}
	
	public boolean option(char choice) {
		boolean deposit = false;
		if((choice == 'Q') || (choice == 'D') || (choice == 'N')) {
			deposit = true;
			takeCoin(choice);
			displayAmount();
		} else if(choice == 'R') {
			giveChange(amount);
		}
		return deposit;
	}
	
	private void takeCoin(char coin){
		if((coin == 'Q') || (coin == 'D') || (coin == 'N')){
			if(coin == 'Q'){
				numQ++;
				amount = amount + 25;
			}
			if(coin == 'D'){
				numD++;
				amount = amount + 10;
			}
			if(coin == 'N'){
				numN++;
				amount = amount + 5;
			}
		}
	}
	
	private void displayAmount(){
		System.out.println("You have deposited " + amount + " cents for this transaction.");
	}
	
}
