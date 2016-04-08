package OBI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Pasazer {
	
	private String imie;
	private String nazwisko;
	private TypPasazera typ; 	// mozliwe typy: KOBIETA, MEZCZYZNA, DZIECKO, NIEMOWLE - typ wyliczeniowy (enum)
	public static int liczbaPasazerowWBazie;
	private List<Bilet> listaBiletowPasazera = new ArrayList<Bilet>();
		
	// konstruktor
	public Pasazer(String imieP, String nazwiskoP, TypPasazera typP){
		imie = imieP;
		nazwisko = nazwiskoP;
		typ = typP;
		++liczbaPasazerowWBazie;
	}
		
	// metoda do wyswietlania podst. informacji na temat pasażera
	public void wyswietlInfoPasazera(){
		System.out.println(imie + ", " + nazwisko + ", "  + typ.name());
		wyswietlListeBiletow();
	}
	
	// metoda dodaje lot do listy lotow pasazera
	public void dodajBiletDoListy(Bilet nowyBilet){
		listaBiletowPasazera.add(nowyBilet);
	}
	// metoda usuwa lot do listy lotow pasazera
	public void usunBiletZListy (Bilet bilet){
		boolean czyUsunietoBilet = false;
		for (int i = 0; i < listaBiletowPasazera.size(); i++){
			if(bilet.getNrBiletu().equals(listaBiletowPasazera.get(i).getNrBiletu())){
				listaBiletowPasazera.remove(i);
				//System.out.println("Usunieto wpis z pozycji : " + (i+1));
				czyUsunietoBilet = true;
				return;
			}
		}
		 if (!czyUsunietoBilet) System.out.println("BLAD! Brak wskazanego biletu na liscie biletow pasazera");
	}
	
	// metoda wyswietla liste lotow pasazera
	public void wyswietlListeBiletow(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		int i = 1;
		if (listaBiletowPasazera.size() > 0){
			for (Bilet bilet : listaBiletowPasazera){	
				System.out.println(i++ + ". " + bilet.getNrBiletu() + ", Lot: " + bilet.getLot().getNumerLotu() + ", Trasa: " + bilet.getLot().getMiejsceWylotu().getMiasto() + " - " 
								+ bilet.getLot().getMiejscePrzylotu().getMiasto() + ", Data wylotu: " + sdf.format(bilet.getLot().getDataWylotu().getTime())
								+ "\t | Oplacony : " + bilet.getCzyBiletOplacony() + " | Odprawiony : " + bilet.getCzyBiltOdprawiony());}
			System.out.println("------------------------ koniec wydruku -------------------------");
		}
		else{ System.out.println("- Brak biletow do wyswietlenia -");}
	}
	
	// dostepne TYLKO cztery typy pasazerow : KOBIETA (MRS), MEZCZYZNA (MR), DZIECKO (CHLD), NIEMOWLE (INF)
	public enum TypPasazera { MRS, MR, CHLD, INF;}
	
	// getters
	public String getImie(){ return imie; }
	public String getNazwisko(){ return nazwisko; }
	public TypPasazera getTypPasazera(){ return typ; }
	public List<Bilet> getListaBiletowPasazera(){ return listaBiletowPasazera;}
		
	// setters
	public void setImie(String imieP){imie = imieP; }
	public void setNazwisko(String nazwiskoP){ nazwisko = nazwiskoP; }
	public void setTypPasazera (TypPasazera typP){ typ = typP;}
}
