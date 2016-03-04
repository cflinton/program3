import java.util.Scanner;
import java.util.Locale;

public class Dispenser {
	private Product[] items;
	private int numItems;
	
	private Scanner scan = new Scanner(System.in).useLocale(Locale.US);
	
	public Dispenser() {
		items = new Product[5];
		numItems = 0;
	}
	
	public String toString() {
		String out = new String();
		for(int i = 0; i < items.length; i++) {
			out = out + (i + 1) + ": " + items[i] + "\n";
		}
		return out;
	}
	
	public boolean option(char choice){	
		int c = (int) choice - 48;
		boolean valid = ((c >= 1) && (c <= numItems));
		return valid;
	}
	
	public void changePrice() {
		System.out.print(toString());
		System.out.print("What is the number of the product you want to reprice? ");
		char n = scan.next().charAt(0);
		System.out.print("What do you want the price to be? ");
		double p = Double.parseDouble(scan.next());
		if(option(n)){
			Product thing = items[(int) n - 49];
			thing.setPrice(p);
		} else {
			System.out.println("Invalid input");
		}
	}
	
	public void restockProduct() {
		System.out.print(toString());
		scan.next();
		System.out.print("What is the number of the product you want to restock? ");
		char n = scan.next().charAt(0);
		System.out.print("How many do you want to add? ");
		int q = scan.nextInt();
		if(option((char) n)){
			Product thing = items[(int) n - 49];
			q = q + thing.getQty();
			thing.setQty(q);
		} else {
			System.out.println("Invalid input");
		}
	}
	
	public double getPrice(char choice) {
		double p = -1;
		
		if(option(choice)){
			Product t = items[((int) choice) - 49];
			p = t.getPrice();
		} else {
			System.out.println("Invalid input on getPrice");
		}

		
		return p;
	}
	
	public boolean inStock(char choice) {
		boolean in = false;
		
		if(option(choice)) {
			Product t = items[((int) choice) - 49];
			in = t.getQty() > 0;
		} else {
			System.out.println("Invalid input on inStock");
		}
		
		return in;
	}
	
	public int dispense(char choice) {
		int d = 0;
		
		if(!option(choice)) {
			System.out.println("Invalid choice on dispense");
		}
		if(!inStock(choice)) {
			System.out.println("Item out of Stock");
		}
		if(inStock(choice) && option(choice)) {
			d = 1;
			Product t = items[((int) choice) - 49];
			t.setQty(t.getQty() - 1);
			items[((int) choice) - 49] = t;
		}
		
		return d;
	}
	
	public void setUpDispenser() {
		
		if(numItems < items.length) {
			scan.next();
			System.out.print("Enter name for new product: ");
			String name = scan.nextLine();
			System.out.print("Enter price for new product: ");
			double pr = Double.parseDouble(scan.next());
			System.out.print("Enter number of items for new product: ");
			int q = scan.nextInt();
			Product t = new Product(name, pr, q);
			boolean placed = false;
			int i = 0;
			while((!placed) && (i < items.length)){
				if(items[i] == null){
					placed = true;
					numItems++;
					items[i] = t;
				}
				i++;
			}
		} else {
			System.out.println("Dispenser is full");
		}
	}
	
	public void deleteProduct(){
		System.out.print(toString());
		System.out.print("What is the number of the product you want to delete? ");
		char n = scan.next().charAt(0);
		if(option(n)){
			items[(int) n - 49] = null;
			numItems--;
		} else {
			System.out.println("Invalid input at deleteProduct");
		}
	}
}
