package OBI;

import java.text.SimpleDateFormat;

public class Bilet {
	
	private String numerBiletu;
	private Lot lot;
	private Pasazer pasazer;
	private int numerMiejsca;
	private Bagaz bagaz;
	private float cenaBiletu;
	private boolean czyOplacony;
	private boolean czyOdprawiony;
	public static int liczbaRezerwowanychBiletow;
	private boolean czyBiletAktywny;
	
	// konstruktor - tworzy nowy bilet (rezerwacje)
	public Bilet(Lot lotB, Pasazer pasazerB){
		lot = lotB;
		pasazer = pasazerB;
		cenaBiletu = obliczCeneBiletu();
		liczbaRezerwowanychBiletow++;
		numerBiletu = generujNumerBiletu();
		czyBiletAktywny = true;
	}
	
	// motoda dodaje bagaz do biletu pasazera
	public void dodajBagaz (Bagaz bagazB){
		if (czyBiletAktywny && !czyOdprawiony){
			bagaz = bagazB;
			cenaBiletu = obliczCeneBiletu();
			czyOplacony = false;
		}
		else System.out.println("BLAD! Bilet odprawiony, nie mozna dodac bagazu");
	}
	// metoda usuwa bagaz z biletu pasazera
	public void usunBagaz(){
		if (czyBiletAktywny && !czyOplacony){
			bagaz = null;
			cenaBiletu = obliczCeneBiletu();
		}
		else System.out.println("BLAD! Bilet oplacony/odprawiony, nie mozna usunac bagazu");
	}
	// metoda przydziela pasazerowi miejsca
	public void przydzielNumerMiejsca(){ 
		int [] numeryBiletow = new int [lot.getMaksymalnaLiczbaPasazerow()];
		for(int i = 0; i < numeryBiletow.length; i++) {numeryBiletow[i] = i+1; }
		for (Bilet bilet : lot.getListaBiletow()){
			for (int i = 0; i < numeryBiletow.length; i++) {
				if (bilet.getNrMiejsca() == numeryBiletow[i]){
					numeryBiletow[i] = 0;
				}
			} 
		}
		for (int i = 0; i < numeryBiletow.length; i++) {
			if (numeryBiletow[i] != 0) {
				numerMiejsca = numeryBiletow[i];
				return;
			}
			
		}
	}
	
	// metoda wyswietla informacje o bilecie
	public void wyswietlInfoBiletu(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		System.out.println("Nr. biletu \t: " + numerBiletu);
		System.out.println("Szczegoly lotu \t: " + lot.getNumerLotu() +", " + lot.getMiejsceWylotu().getMiasto() + " ("+ lot.getMiejsceWylotu().getKodLotniska() + ") - " 
				+ lot.getMiejscePrzylotu().getMiasto() + " (" + lot.getMiejscePrzylotu().getKodLotniska() + "), " + sdf.format(lot.getDataWylotu().getTime()) );
		if (numerMiejsca > 0) System.out.println("Nr. miejsca \t: " + numerMiejsca);
		else System.out.println("Nr. miejsca \t: BRAK");
		System.out.println("Pasazer \t: " + pasazer.getTypPasazera().name() + ", " + pasazer.getImie() + " " + pasazer.getNazwisko());
		if (bagaz != null) System.out.println("Bagaz \t\t: " + bagaz.getWagaBagazu() + " kg");
		else System.out.println("Bagaz \t\t: BRAK");
		System.out.println("Cena biletu\t: " + cenaBiletu + " \u20AC");
		if (czyOplacony) System.out.println("Oplacony bilet\t: TAK");
		else System.out.println("Oplacony bilet\t: NIE");
		if (czyOdprawiony) System.out.println("Odprawiony \t: TAK");
		else System.out.println("Odprawiony \t: NIE");
		if (czyBiletAktywny) System.out.println("Bilet aktywny? \t: TAK (!)");
		else System.out.println("Bilet aktywny? \t: NIE (!)");
	}
	
	// getters	
	public String getNrBiletu(){ return numerBiletu; }
	public Lot getLot(){ return lot; }
	public Pasazer getPasazer(){ return pasazer; }
	public int getNrMiejsca(){ return numerMiejsca; }
	public Bagaz getBagaz(){ return bagaz; }
	public float getCenaBiletu(){ return cenaBiletu; }
	public boolean getCzyBiletOplacony(){ return czyOplacony;}
	public boolean getCzyBiltOdprawiony(){ return czyOdprawiony;}
	public boolean getCzyBiletAktywny(){return czyBiletAktywny;}
	
	// setters
	public void setLot(Lot lotB){ lot = lotB; }
	public void setPasazer(Pasazer pasazerB) { pasazer = pasazerB;}
	public void setNumerMejsca (int nrMiejsca){ numerMiejsca = nrMiejsca;}
	public void setCzyBiletAktywny(boolean czyAktywny) { czyBiletAktywny = czyAktywny;}
	
	// metoda ustawia parametr oplacony
	public boolean setBiletOplacony(){ return czyOplacony = true;}
	// metoda ustawia parametr odprawiony
	public boolean setBiletOdprawiony(){ 
		if (czyOplacony) czyOdprawiony = true;
		else System.out.println("BLAD! Bilet jeszcze nie oplacony");
		return czyOdprawiony;}
	
	
	// pomocnicza metoda oblicza cene biletu
	private float obliczCeneBiletu(){
		float cenaPodst = lot.getDlugoscTrasy() * 0.1f;		// Podstawowa cena za lot to 0.1 euro za kilometr
		if (pasazer.getTypPasazera().toString() == "CHLD") { cenaPodst *= 0.6;}			// Dziecko placi 60% ceny
		else if(pasazer.getTypPasazera().toString() == "INF") { cenaPodst *= 0.3; }	// Niemowle placi 30% ceny
		if(bagaz != null) cenaPodst += bagaz.getCenaBagazu();
		cenaPodst = Math.round(cenaPodst*100);
		cenaPodst /=100;
		return cenaPodst;
	}
	// pomocnicza metoda generuje numer biletu
	private String generujNumerBiletu(){
		String pustyBilet = "000000";
		String tempBilet = "" + liczbaRezerwowanychBiletow;
		String nrBiletu = pustyBilet.substring(0, pustyBilet.length()-tempBilet.length()) + liczbaRezerwowanychBiletow;
		return nrBiletu;
	}
	
	// metoda drukuje bilet
		public void drukujBilet(){
			if (czyOplacony && czyOdprawiony && czyBiletAktywny){
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				System.out.println("\n******************************************************************************");
				System.out.println("*                                                          Ticket No. " + numerBiletu + " *");
				System.out.print("* Name : " + pasazer.getNazwisko() + ", " + pasazer.getImie() + " (" + pasazer.getTypPasazera().name() +")       " + "\tSeat No. " + numerMiejsca);
				System.out.println("                           *"); 
				System.out.println("*                                                          Flight No. " + lot.getNumerLotu() + " *") ;
				System.out.println("*  Departure date : " + sdf.format(lot.getDataWylotu().getTime()) + "      " + lot.getMiejsceWylotu().getMiasto() + "\t\t\t     *");
				System.out.println("*  Arrival date   : " + sdf.format(lot.getDataPrzylotu().getTime()) + "      " + lot.getMiejscePrzylotu().getMiasto() + " \t\t\t     *");
				System.out.println("*                                                                            *");
				if (bagaz == null){ System.out.println("*  Baggage : NO                                                              *");}
				else {System.out.println("*  Baggage : YES (" + bagaz.getWagaBagazu() + " kg)                                                   *");}
				System.out.println("*                                                         PRICE : " + cenaBiletu + " \u20AC   *");
				System.out.println("******************************************************************************");
			}
			else { System.out.println("BLAD! Bilet nie oplacony i/lub nie odprawiony lub bilet nie jest juz aktywny!");}
		}
		
}
