public class ProductTest {
	public static void main(String[] args) {
		System.out.println("Testing blank constructor");
		Product cc = new Product();
		System.out.println("Testing non-blank constructor");
		Product pep = new Product("Pepsi", 4.95, 7);
		String str = cc.getName();
		System.out.println("Blank name is " + str);
		str = pep.getName();
		System.out.println("Filled name is " + str);
		pep.setName("Poopsi");
		str = pep.getName();
		System.out.println("New Name is " + str);
		double pr;
		pr = cc.getPrice();
		System.out.println("Blank price is " + pr);
		pr = pep.getPrice();
		System.out.println("Filled price is " + pr);
		pep.setPrice(55.55);
		pr = pep.getPrice();
		System.out.println("New price is " + pr);
		int q;
		q = cc.getQty();
		System.out.println("Blank quantity is " + q);
		q = pep.getQty();
		System.out.println("Filled quantity is " + q);
		pep.setQty(666);
		q = pep.getQty();
		System.out.println("New quantity is " + q);
		System.out.println("Blank toString is " + cc);
		System.out.println("Filled toString is " + pep);
	}
}
