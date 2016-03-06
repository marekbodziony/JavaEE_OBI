package OBI;

public class Pasazer {
	
	private String imie;
	private String nazwisko;
	private String plec;
	private int wiek;
	
	public Pasazer(String imieP, String nazwiskoP, String plecP, int wiekP){
		
		imie = imieP;
		nazwisko = nazwiskoP;
		plec = plecP;
		wiek = wiekP;
	}
	
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
