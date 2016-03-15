package OBI;


public class RezerwujBilet {

	public static void main(String[] args) {

		//Baza dostepnych samolotow
		Samolot airForceOne = new Samolot("Boeing-747",70,"01.01.2002","13.07.2013");
		Samolot samolotAirbus = new Samolot("Airbus A320",120,"08.01.1991","10.03.2015");
				
		// Baza dostępnych lotów
		Lot lotVIP = new Lot("FL241","Chicago","Londyn","09:30, 12.03.2016","17:00, 12.03.2016", airForceOne);
		Lot WroKrak = new Lot("AB789","Wroclaw","Krakow","07:20, 17.03.2016","08:05, 17.03.2016", samolotAirbus);
				
		//Pasazerowie
		Pasazer pasazerVip = new Pasazer("Barack","Obama","M",45,lotVIP);
		Pasazer pasazer1 = new Pasazer("Jan","Kowalski","M",35,WroKrak,21);
		Pasazer pasazer2 = new Pasazer("Anna","Michalik","F",31,WroKrak,18);
				
		
		//Rezeracja biletu
		Bilet bilet = new Bilet(001502322376, pasazerVip,"21A",45.50f);
		bilet.drukujBilet();
		
	}
}
