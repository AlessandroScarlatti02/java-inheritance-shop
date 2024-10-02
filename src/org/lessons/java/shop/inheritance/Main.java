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

		Smartphone s1 = new Smartphone(0, 1024, 0, "Iphone 16 Pro Max", "Apple", 1150, 1.22);
		s1.getProductInformations(s1);
		
		Headphones h1 = new Headphones("Blue", true, 0, "Bose QuietComfort", "Bose", 298.99, 1.22);
		h1.getProductInformations(h1);
	}

}
