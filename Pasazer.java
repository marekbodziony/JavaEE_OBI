package OBI;

public class Pasazer {
	
	private String imie;
	private String nazwisko;
	private String plec;
	private int wiek;
	private Lot lot;
	private Bagaz bagaz;
	
	// konstruktor (pasazer bez bagazu)
	public Pasazer(String imieP, String nazwiskoP, String plecP, int wiekP, Lot lotP){
		
		imie = imieP;
		nazwisko = nazwiskoP;
		plec = plecP;
		wiek = wiekP;
		lot = lotP;
	}
	// konstruktor (pasazer z bagazem)
		public Pasazer(String imieP, String nazwiskoP, String plecP, int wiekP, Lot lotP, int wagaBag){
			
			imie = imieP;
			nazwisko = nazwiskoP;
			plec = plecP;
			wiek = wiekP;
			lot = lotP;
			bagaz = new Bagaz(this, wagaBag);
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
	public Lot getLot(){
			return lot;
	}
	public Bagaz getBagaz(){
		return bagaz;
	}
	// setters
	public void setLot(Lot lotP){
		lot = lotP;
	}
	public void setBagaz(int wagaBag){
		bagaz = new Bagaz(this, wagaBag);
	}
	
	// metoda do wyswietlania podst. informacji na temat pasażera
		public void wyswietlInfoPasazera(){
			System.out.println("Imie     : " + imie);
			System.out.println("Nazwisko : " + nazwisko);
			System.out.println("Plec     : " + plec);
			System.out.println("Wiek     : " + wiek );
			System.out.println("Lot      : " + lot.getPoczatekTrasy() + "-" + lot.getKoniecTrasy());
			if (bagaz == null){ System.out.println("Bagaz    : BRAK");}
				else {System.out.println("Bagaz    : TAK (" + bagaz.getWagaBagazu() + " kg)");}
		}
}
