package org.lessons.java.shop.inheritance;

public class Main {

	public static void main(String[] args) {

		Product p1 = new Product(0, "Hisense", "Hisense", 399.99, 1.22);
		p1.getProductInformations(p1);
			
		double completePrice;
		
		completePrice= p1.getCompletePrice();
		System.out.println(completePrice);
		
		Tv t1 = new Tv(55, true, 0, "TV OLED", "LG", 895.00, 1.22);
		t1.getProductInformations(t1);

	}

}
