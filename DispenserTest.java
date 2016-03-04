public class DispenserTest {
	public static void main(String[] args) {
		System.out.println("Testing constructor.");
		Dispenser d = new Dispenser();
		d.setUpDispenser();
		d.setUpDispenser();
		d.setUpDispenser();
		d.setUpDispenser();
		d.setUpDispenser();
		d.setUpDispenser();

		if(d.option((char) 1)){
			System.out.println("option for casted 1 returned true");		
		} else {
			System.out.println("option for casted 1 returned false");
		}

		if(d.option('1')){
			System.out.println("option for '1' returned true");		
		} else {
			System.out.println("option for '1' returned false");
		}
		
		d.changePrice();
		System.out.print("getPrice reads: " + d.getPrice('1') + '\n');
		
		if(d.inStock('1')){
			System.out.println("inStock returned true");
		} else {
			System.out.println("inStock returned false");
		}
		
		System.out.println("dispense returns: " + d.dispense('1'));
		
		d.restockProduct();
		System.out.print(d.toString());
		
		while(d.dispense('1') == 1)
		
		d.dispense('1');
		
		d.deleteProduct();
		System.out.print(d.toString());
	}
}
