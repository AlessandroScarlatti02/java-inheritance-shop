package org.lessons.java.shop.inheritance;

import java.util.Random;

public class Product {
	
	private int code;
	
	private String name;
	
	private String brand;
	
	private double price = 100;
	
	private double iva = 1.22;
	
	
	public Product(String name, String brand) {
	
		setCode();
		setName(name);
		setBrand(brand);
		System.out.println("Prodotto " + this.name + " creato correttamente \n" );
	}
	
	public Product(int code, String name, String brand) {
	
		checkCode(code);
			
		setName(name);
		setBrand(brand);
		
		System.out.println("Prodotto " + this.name + " creato correttamente \n" );
	}
	
	public Product(int code, String name, String brand, double price) {
	
		checkCode(code);
		
		setName(name);
		setBrand(brand);
		
		setPrice(price);
		System.out.println("Prodotto " + this.name + " creato correttamente \n" );
	}
	
	
	public Product(int code, String name, String brand, double price, double iva) {
	
		checkCode(code);
		
		setName(name);
		setBrand(brand);
		
		setPrice(price);
		
		setIva(iva);
		System.out.println("Prodotto " + this.name + " creato correttamente \n" );
	}
	
	private void checkCode(int code) {
		if (code>0 && code<=9999) {
			this.code = code;
		} else {
			setCode();
			System.out.println("Codice inserito non valido, codice generato randomicamente");
			System.out.println("Codice: " + this.code);
		}
	}
	
	private void setCode(){
		
		Random ran = new Random();
		code = ran.nextInt(10000);

	}
	
	
	void setName(String name) {
		if (name!=null) {
			this.name=name;
		}else {
			System.out.println("Il valore name non può essere NULL");
		}
	}
	
	String getName() {
		return name;
	}
	
	
	
	
	
	void setBrand(String brand) {
		
		if (brand!=null) {
			this.brand=brand;
		}else {
			System.out.println("Il valore brand non può essere NULL");
		}
	}
	
	String getBrand() {
		return brand;
	}
	
	
	
	
	
	void setPrice(double price) {
		if (price>=0) {
			this.price=price;
		}else {
			System.out.println("Prezzo inserito non valido, inserimento nuovo prezzo non eseguito");
		}
	}

	double getPrice() {
			return price;
	}
	

	

	
	void setIva (double iva) {
		if (iva==1.22 || iva==1.10 || iva==1.04) {
			this.iva=iva;
		}else {
			System.out.println("Valore IVA inserito non valido, iva non modificata.");
		}
	}

	double getIva() {
		return iva;
	}
	
	double getCompletePrice() {
		return price*iva;
	}
	
	void getProductInformations(Product product) {
		
		System.out.println(product.toString());
		
	}
	
	@Override
	public String toString() {
		
		return 	"Codice: " + code + "\n" +
				"Nome: " + name + "\n" +
				"Marca: " + brand + "\n" +
				"Prezzo: " + price + "\n" +
				"Iva: " + iva + "\n" + 
				"Prezzo Completo: " + getCompletePrice() + "\n";
	}

}
