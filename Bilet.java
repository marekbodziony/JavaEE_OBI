package OBI;


public class Bilet {
	
	private Pasazer pasazer;
	private Lot lot;
	private int numerBiletu;
	private String numerMiejsca;
	private float cenaBiletu;
	Bagaz bagaz;
	
	// konstruktor 
	public Bilet(int biletNr, Pasazer pasazerB, String miejsceNr, float cenaB){
		
		numerBiletu = biletNr;
		pasazer = pasazerB;
		lot = pasazerB.getLot();
		numerMiejsca = miejsceNr;
		cenaBiletu = cenaB;
		if (pasazerB.getBagaz() != null) bagaz = pasazerB.getBagaz();
	}
	
	// getters	
	public int getNrBiletu(){
		return numerBiletu;
	}
	public Pasazer getPasazer(){
		return pasazer;
	}
	public Lot getLot(){
		return lot;
	}
	public String getNrMiejsca(){
		return numerMiejsca;
	}
	public float getCenaBiletu(){
		return cenaBiletu;
	}
	public Bagaz getBagaz(){
		return bagaz;
	}
	// setters
	public void setLot(Lot lotB){
		lot = lotB;
	}
	public void setNumerBiletu(int biletNr){
		numerBiletu = biletNr;
	}
	public void setNumerMiejsca(String miejsceNr){
		numerMiejsca = miejsceNr;
	}
	public void setCenaBiletu(float cenaB){
		cenaBiletu = cenaB;
	}
	
	// metoda wyswietla bilet
		public void drukujBilet(){
			System.out.println("\n*********************************************************************************");
			System.out.println("*                                                          Ticket No. " + numerBiletu + " *");
			System.out.print("* Name : " + pasazer.getNazwisko() + ", " + pasazer.getImie() + " (" + pasazer.getPlec() +")       " + "Seat No. " + numerMiejsca);
			System.out.println("                                   *"); 
			System.out.println("*                                                          Flight No. " + lot.getNumerLotu() + "     *") ;
			System.out.println("*  Departure date : " + lot.getDataWylotu() + "      " + lot.getPoczatekTrasy() + "                              *");
			System.out.println("*  Arrival date   : " + lot.getDataPrzylotu() + "      " + lot.getKoniecTrasy() + "                               *");
			System.out.println("*                                                                               *");
			if (bagaz == null){ System.out.println("*  Baggage : NO                                                                 *");}
			else {System.out.println("*  Baggage : YES (" + bagaz.getWagaBagazu() + " kg)                                                      *");}
			System.out.println("*                                                              PRICE : " + cenaBiletu + " $   *");
			System.out.println("*********************************************************************************");
		}
		
}
