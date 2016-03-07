package OBI;


public class Bilet {
	
	private Pasazer pasazer;
	private Lot lot;
	private String numerMiejsca;
	private float cenaBiletu;
	
	public Bilet(Pasazer pas, Lot lot, String miejsceNr, float cena){
		
		numerMiejsca = miejsceNr;
		cenaBiletu = cena;
	}

}
