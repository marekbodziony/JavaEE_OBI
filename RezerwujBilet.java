package OBI;


import java.util.GregorianCalendar;

import OBI.Pasazer.TypPasazera;

public class RezerwujBilet {

					
	// metoda do rezerwacji biletu na lot - dane pasazera z bazy
	public static Bilet rezerwujBilet(Lot lot, Pasazer pasazer){
		// jesli sa wolne miejsca na lot to stworz nowy 'bilet' i dodaj go do listy pasazera oraz do listy lotu
		if(lot.getListaBiletow().size() < lot.getMaksymalnaLiczbaPasazerow()){
			Bilet bilet = new Bilet(lot,pasazer);
			pasazer.dodajBiletDoListy(bilet);
			lot.dodajBiletDoListy(bilet);
			bilet.setCzyRezerwacjaAktywna(true);
			//System.out.println("OK! Bilet o nr " + bilet.getNrBiletu() + " zostal zarezerowany. Prosze oplacic bilet.");
			return bilet;
		}
		// jesli nie ma wolnych miejsc na wybrany lot 
		else {
			System.out.println("BLAD! Brak wolnych miejsc na dany lot!");	
			return null;
		}
	}
	
	// metoda do anulowania rezerwacji
	public static void anulujBilet(Bilet bilet){
		// jesli bilet nieaktywny (nie zostal dodany do lotu z braku miejsc lub zostal juz usuniety)
		if (!bilet.getCzyRezerwacjaAktywnya()){ System.out.println("BLAD! Nie znaleziono biletu do anulowania"); return;}
		// jesli bilet aktywny to usun go z listy pasazera i listy lotu (dodatkowo zmien status na nieaktywny)
		bilet.getLot().usunBiletZListy(bilet);
		bilet.getPasazer().usunBiletZListy(bilet);
		bilet.setCzyRezerwacjaAktywna(false);
		System.out.println("OK! Bilet nr. " + bilet.getNrBiletu() + " zostal anulowany.");
	}
	// metoda do oplacania bileu
	public static void oplacBilet(Bilet bilet){
		//if (bilet == null) {return;}
		if (!bilet.getCzyRezerwacjaAktywnya()){ System.out.println("BLAD! Nie znaleziono biletu do oplacenia"); return;}
		if (bilet.getCzyBiletOplacony()){ System.out.println("BLAD! Bilet juz zostal oplacony"); return;}
		// jesli bilet jest aktywny i nieoplacony
		bilet.setBiletOplacony();
		System.out.println("Oplacono bilet nr. " + bilet.getNrBiletu());
	}
	// metoda do odprawiania biletu
	public static void odprawBilet(Bilet bilet){
		if (!bilet.getCzyRezerwacjaAktywnya()){ System.out.println("BLAD! Nie znaleziono biletu do odprawy"); return;}
		if (bilet.getCzyBiletOplacony() && !bilet.getCzyBiletOdprawiony()) {
			bilet.setBiletOdprawiony();
			bilet.przydzielNumerMiejsca();    // przydziele miejsce podczas odprawy
			//bilet.getLot().dodajBiletDoListy(bilet);
			System.out.println("Odprawiono bilet. Milej podrozy!");
		}
		else if (!bilet.getCzyBiletOplacony()) System.out.println("BLAD! Bilet jeszcze nie oplacony");
		else if (bilet.getCzyBiletOplacony() && bilet.getCzyBiletOdprawiony()) System.out.println("BLAD! Bilet juz zostal odprawiony");				
	}

}
