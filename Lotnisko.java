package OBI;

public class Lotnisko {
	private String nazwaLotniska;
	private String kodLotniska;
	private String miasto;
	private String kraj;
	
	// constructor
	public Lotnisko (String nazwaL, String kodL, String miastoL, String krajL){
		nazwaLotniska = nazwaL;
		kodLotniska = kodL;	
		miasto = miastoL;
		kraj = krajL;
	}
	
	// metoda wyswietla informacje o lotnisku
	public void wyswietlInfoLotniska(){
		System.out.println(nazwaLotniska + ", " + kodLotniska + ", " + miasto + ", " + kraj);
	}
	
	//getters
	public String getMiasto(){ return miasto;}
	public String getKraj(){ return kraj;}
	public String getNazwaLotniska(){ return nazwaLotniska;}
	public String getKodLotniska(){ return kodLotniska;}
	
	// setters
	public void setMiasto(String miastoL){ miasto = miastoL;}
	public void setKraj (String krajL){ kraj = krajL;}
	public void setkodLotniska(String kod){ kodLotniska = kod;}
	public void setNazwaLotniska(String nazwaL) {nazwaLotniska = nazwaL;}
}
