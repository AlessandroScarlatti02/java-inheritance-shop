package org.lessons.java.shop.inheritance;

public class Headphones extends Product {

	private String color;
	
	private boolean wireless=false;
	
	
	public Headphones(String color, boolean wireless, int code, String name, String brand, double price, double iva) {
	
		super(code, name, brand, price, iva);
		
		setColor(color);
		setWireless(wireless);
	}
	
	
	public void setColor(String color) {
		if (color.length()>2) {
			this.color = color;
		} else {
			System.out.println("il colore inserito non è valido, colore delle cuffie non modificato\n"+"Colore attuale: " + this.color);
		}			
	}
	
	public String getColor() {
		return color;
	}
	
	
	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}
	
	
	public boolean getWireless() {
		return wireless;
	}
	

	void getProductInformations(Headphones headphones) {
		super.getProductInformations(headphones);
	}
	
	@Override
	public String toString() {
		String message = "No";
		
		if (wireless) {
			message="Si";
		}
		return super.toString()+
				"Colore: " + color + "\n" +
				"Wireless: " + message +"\n";
	}
}
