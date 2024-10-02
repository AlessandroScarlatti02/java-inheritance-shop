package org.lessons.java.shop.inheritance;

public class Tv extends Product{

	private int inch;
	
	private boolean smart=true;
	
	public Tv(int inch, boolean smart,int code ,String name, String brand, double price, double iva) {
		super(code, name, brand, price, iva);
		
		setInch(inch);
		setSmart(smart);
		
		
	}
	
	
	public void setInch(int inch) {
		if (inch>0 && inch<101) {
			this.inch = inch;
		}else {
			System.out.println("Valore di pollici inserito non valido inserire un numero compreso tra 1\" e 100\" \n"
					+ "Valore di pollici attuale: "+this.inch);
		}
	}
	
	public int getInch() {
		return inch;
	}
	
	
	public void setSmart(boolean smart) {
		this.smart = smart;
	}
	
	public boolean getSmart() {
		return smart;
	}
	
	void getProductInformations(Tv tv) {
	
		super.getProductInformations(tv);
	}
	
	@Override
	public String toString() {
		String message = "No";
		
		if (smart) {
			message="Si";
		}
		return super.toString()+
				"Pollici: " + inch + "\n" +
				"Smart: " + message +"\n";
	}
}
