package OBI;

public class Bagaz {
	
	private Pasazer pasazer;
	private Lot lot;
	private float wagaBagazu;
	
	// konstruktor
	public Bagaz(Pasazer pasazerBag, int wagaBag){
		
		pasazer = pasazerBag;
		lot = pasazerBag.getLot();
		wagaBagazu = wagaBag;
	}
	
	// getters
	public Pasazer getPasazer(){
		return pasazer;
	}
	public Lot getLot(){
		return lot;
	}
	public float getWagaBagazu(){
		return wagaBagazu;
	}
	
	// setters
	public void setWagaBagazu(float wagaBag){
		wagaBagazu = wagaBag;
	}
}
