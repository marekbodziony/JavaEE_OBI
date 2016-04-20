package OBI;

import java.util.GregorianCalendar;

import OBI.Pasazer.TypPasazera;

public class Test {
				
	
	public static void main (String[] args){
		
		// Baza lotnisk
				Lotnisko londynHeathrow = new Lotnisko("Heathrow Airport", "HTR", "Londyn", "Wielka Brytania");
				Lotnisko wawaChopin = new Lotnisko("Warsaw Chopin Airport", "WAW", "Warszawa", "Polska");
				Lotnisko wawaModlin = new Lotnisko("Warsaw Modlin Airport", "WMI", "Modlin", "Polska");
				Lotnisko chicagoOhare = new Lotnisko("O’Hare International Airport", "ORD", "Chicago", "Stany Zjednoczone");
					
			// Baza dostępnych lotów
				Lot wawaChop_chicago = new Lot("LO3923", wawaChopin, chicagoOhare, 7512.74f, new GregorianCalendar(2016,04,20, 14,35), new GregorianCalendar(2016,04,20, 15,50), 150);
				Lot chicago_londyn = new Lot("WI1087", chicagoOhare, londynHeathrow, 6356.69f, new GregorianCalendar(2016,05,13, 05,00), new GregorianCalendar(2016,05,13, 12,30), 190);
				Lot londyn_wawaChop = new Lot("LO2205", londynHeathrow, wawaChopin, 7512.74f, new GregorianCalendar(2016,05,13, 18,00),new GregorianCalendar(2016,05,13, 20,10), 180);
				Lot wawaMod_londyn = new Lot("FR1730", wawaModlin, londynHeathrow, 1448.29f, new GregorianCalendar(2016,06,01, 17,00), new GregorianCalendar(2016,06,01, 18,20), 120);
					
			// Baza pasazerow
				Pasazer p1 = new Pasazer("Marek","Bodziony",TypPasazera.MR);
				Pasazer p2 = new Pasazer("Nikodem","Bodziony",TypPasazera.CHLD);
				Pasazer p3 = new Pasazer("Janina", "Kowalska",TypPasazera.MRS);
				Pasazer p4 = new Pasazer("Ania","Kowalska",TypPasazera.INF);
		
	
		new	RezerwacjaGUI().setSize(1000, 800);	
				
		//--------------------- SYSTEM REZERWACJI BILETOW -------------------------------
		
		// ----------- 0. Wyszukanie lotu, podanie danych pasazera ----------------------
		Lot lot = chicago_londyn;
		Pasazer pasazer = p1;
		
		
		// ----------- 1. Rezeracja biletu ----------------------------------------------
		//RezerwujBilet.rezerwujBilet(lot1,p3);				// tworzy nowa rezerwacje (nowy bilet) na lot dla pasazera (z bazy danych)
		//ticket.dodajBagaz(new Bagaz());										// mozna dodac bagaz podczas rezerwacji lub podczas odprawy
		//ticket.usunBagaz();		
		
				
		
		// ----------- 2. Platnosc za bilet ------------------
		//System.out.println("> Cena biletu = " + ticket.getCenaBiletu() + " \u20AC");
		 //RezerwujBilet.oplacBilet(ticket);
	
		
		// ----------- 3. Anulowanie biletu -------------------
		//anulujBilet(ticket);
		
		// ----------- 4. Odprawa biletu ----------------------
		//ticket.dodajBagaz(new Bagaz(27));
		//oplacBilet(ticket);
		// RezerwujBilet.odprawBilet(ticket);
			
				
		
		//ticket.drukujBilet();
		
		// ----------- 5. Zrealizowano bilet (KONIEC PORCESU) -----
		 //lot.zrealizujLot();
		
		
			
			
		//lot1.wyswietlListeBiletow();
		//lot2.wyswietlListeBiletow();
		
	}

}
