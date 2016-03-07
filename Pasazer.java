package OBI;

public class Pasazer {
	
	private String imie;
	private String nazwisko;
	private String plec;
	private int wiek;
	
	// konstruktor
	public Pasazer(String imieP, String nazwiskoP, String plecP, int wiekP){
		
		imie = imieP;
		nazwisko = nazwiskoP;
		plec = plecP;
		wiek = wiekP;
	}
	
	// metoda do wyswietlania informacji na temat pasażera
	public void wyswietlInfoPasazera(){
		System.out.println("Imie     : " + imie);
		System.out.println("Nazwisko : " + nazwisko);
		System.out.println("Płeć     : " + plec);
		System.out.println("Wiek     : " + wiek );
	}
	
	// getters
	public String getImie(){
		return imie;
	}
	public String getNazwisko(){
		return nazwisko;
	}
	public String getPlec(){
		return plec;
	}
	public int getWiek(){
		return wiek;
	}
}
