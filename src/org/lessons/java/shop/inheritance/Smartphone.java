package org.lessons.java.shop.inheritance;

import java.util.Random;

public class Smartphone extends Product {

	private int imei;
	
	private int storage = 128;
	
	public Smartphone(int imei, int storage,int code ,String name, String brand, double price, double iva) {
		super(code, name, brand, price, iva);
		
		setImei(imei);
		setStorage(storage);
	}
	
	
	private void setImei(int imei) {
		if (imei>0&&imei<1000000000) {
			this.imei = imei;
		}else {
			Random ran = new Random();
			this.imei = ran.nextInt(1000000000);
		}
	}
	
	public int getImei() {
		return imei;
	}
	
	
	public void setStorage(int storage) {
		if (storage == 64 || storage == 128 || storage == 256 || storage == 512 || storage == 1024 || storage == 2048) {
			this.storage = storage;
		}else {
			System.out.println("La capacità di memoria inserita non è valida, inserita nel prodotto memoria standard 128GB");
		}
			
	}
	
	public int getStorage() {
		return storage;
	}

	
	
	
	void getProductInformations(Smartphone smartphone) {

		super.getProductInformations(smartphone);
	}
	
	
	@Override
	public String toString() {

		return super.toString()+
				"IMEI: " + imei + "\n" +
				"Memoria: " + storage +"GB"+"\n";
	}
}
