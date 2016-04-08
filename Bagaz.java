package OBI;

public class Bagaz {
	
	private float wagaBagazu;
	private float cenaBagazu;
	public static final float LIMIT_WAGI_BAGAZU = 20;	// 20 kg
	public static final float PODST_CENA_BAGAZU = 15;	// 15 euro
	public static final float ZA_NADBAGAZ = 2; 			// 2 euro za kazdy kg nadbagazu
		
	// konstruktor
	public Bagaz(){
		cenaBagazu = PODST_CENA_BAGAZU;
	}
	public Bagaz(float wagaBag){
		wagaBagazu = wagaBag;
		cenaBagazu = obliczCeneBagazu(wagaBag);
	}
	
	// wyswietl info o bagazu
	public void wyswietlInfoBagazu(){
		System.out.println("Bagaz : " + wagaBagazu + " kg");
		System.out.println("Cena za bagaz: " + cenaBagazu + " \u20AC");
	}
	
	// getters
	public float getWagaBagazu(){ return wagaBagazu; }
	public float getCenaBagazu(){ return cenaBagazu;}
	
	// setters
	public void setWagaBagazu(float wagaBag){ 
		wagaBagazu = wagaBag;
		cenaBagazu = obliczCeneBagazu(wagaBag);
	}
	
	// pomocnicza metoda do obliczenia ceny bagazu (w zaleznosci od wagi)
	private float obliczCeneBagazu(float wagaBag){
		float cenaBag = PODST_CENA_BAGAZU;
		if (wagaBag > LIMIT_WAGI_BAGAZU) { 
			cenaBag += (wagaBag - LIMIT_WAGI_BAGAZU) * ZA_NADBAGAZ; 
			cenaBag = Math.round(cenaBag*100);
			cenaBag /= 100;
		} 
		return cenaBag;
	}
}
