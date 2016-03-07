package OBI;


public class Bilet {
	
	private Pasazer pasazer;
	private Lot lot;
	private String numerMiejsca;
	private float cenaBiletu;
	private Bagaz bagaz;
	
	// konstruktor1 (pasażer leci z bagażem)
	public Bilet(Pasazer pas, Lot l, String miejsceNr, float cena, Bagaz bag){
		pasazer = pas;
		lot = l;
		numerMiejsca = miejsceNr;
		cenaBiletu = cena;
		bagaz = bag;
	}
	// konstruktor2 (pasażer leci bez bagazu)
	public Bilet(Pasazer pas, Lot l, String miejsceNr, float cena){
		pasazer = pas;
		lot = l;
		numerMiejsca = miejsceNr;
		cenaBiletu = cena;
	}

}
