package OBI;


public class RezerwujBilet {

	public static void main(String[] args) {

		//Rezerwacja
		
		Samolot airForceOne = new Samolot("Boeing-747",150,"01.01.1998","13.07.2013");
		
		Lot lotDoLondynu = new Lot("Waszyngton","Londyn","09:30, 12.03.2016","17:00, 12.03.2016", airForceOne);
	
		Pasazer pasazer1 = new Pasazer("Jan","Kowalski","M",35);

		lotDoLondynu.wyswietlInfoLotu();
		
	}
}
