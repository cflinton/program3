import java.util.Scanner;

public class VendingMachine {
	private Dispenser snackMachine;
	private Coinbox moneyBox;
	private Scanner scan = new Scanner(System.in);
	
	public VendingMachine() {
		snackMachine = new Dispenser();
		moneyBox = new Coinbox(5, 5, 5);
		while(!bossWork()) {
			run();
		}
	}
	
	public void run() {
		char c = 'Z';
		
		while(c != '0') {
			showUserChoice();
			System.out.print("Enter your choice: ");
			c = scan.next().charAt(0);
			serviceCustomer(c);
		}
	}
	
	private void showUserChoice() {
		System.out.println("0: Enter boss mode");
		System.out.print(snackMachine.toString());
		moneyBox.displayCoins();
		System.out.println("Enter money first and then select a product.");
	}
	
	private void serviceCustomer(char choice) {
		if(moneyBox.option(choice)) {
			System.out.println("Coin inserted");
		} else if(snackMachine.option(choice)) {
			double amount = ((double) moneyBox.getAmount()) / 100; //converts amount from cents to dollars
			System.out.println("Converted amount: " + amount);
			if(amount >= snackMachine.getPrice(choice)) {
				if(snackMachine.dispense(choice) == 1) {
					int change = (int) ((amount - snackMachine.getPrice(choice)) * 100); // finds amount owed in dollars and converts it to cents
					System.out.println("Change is: " + change + " cents.");
					moneyBox.giveChange(change);
				}
			} else {
				System.out.println("Not enough money");
			}
		} else if (choice != '0') {
			System.out.println("Invalid Choice");
		}
	}
	
	private boolean bossWork(){
		boolean shutdown = true;
		int choice = 9;
		while(choice != 0 && choice != 1) {
			scan.next();
			System.out.println("0: Shutdown");
			System.out.println("1: run in user mode");
			System.out.println("2: add a product");
			System.out.println("3: delete a product");
			System.out.println("4: change a product's price");
			System.out.println("5: restock a product");
			System.out.print("Enter your choice: ");
			choice = scan.nextInt();
			switch(choice) {
				case 0: System.out.println("Shuting Down...");
					shutdown = true;
					break;
				case 1: shutdown = false;
					break;
				case 2: snackMachine.setUpDispenser();
					break;
				case 3: snackMachine.deleteProduct();
					break;
				case 4: snackMachine.changePrice();
					break;
				case 5: snackMachine.restockProduct();
					break;
				default: System.out.println("Not a Boss operation");
			}
		}
		return shutdown;
	}
	
}
