package OBI;


public class Lot {
	
	private String numerLotu;
	private String poczatekTrasy;
	private String koniecTrasy;
	private String dataWylotu;
	private String dataPrzylotu;
	private Samolot samolot;
		
	public Lot(String lotNr, String poczTrasy, String konTrasy, String dataWyl, String dataPrzyl,Samolot sam){
		
		numerLotu = lotNr;
		poczatekTrasy = poczTrasy;
		koniecTrasy = konTrasy;
		dataWylotu = dataWyl;
		dataPrzylotu = dataPrzyl;
		samolot = sam;
	}

	// getters
	public String getNumerLotu(){
		return numerLotu;
	}
	public String getPoczatekTrasy(){
		return poczatekTrasy;
	}
	public String getKoniecTrasy(){
		return koniecTrasy;
	}
	public String getDataWylotu(){
		return dataWylotu;
	}
	public String getDataPrzylotu(){
		return dataPrzylotu;
	}
	public Samolot getSamolotObslugujacyLot(){
		return samolot;
	}
	
	// setters
	public void setNumerLotu(String lotNr){
		numerLotu = lotNr;
	}
	public void setPoczatekTrasy(String poczTrasy){
		poczatekTrasy = poczTrasy;
	}
	public void setKoniecTrasy(String konTrasy){
		koniecTrasy = konTrasy;
	}
	public void setPoczatekOrazKoniecTrasy(String poczTrasy, String konTrasy){
		poczatekTrasy = poczTrasy;
		koniecTrasy = konTrasy;
	}
	public void setDataWylotu(String dataWyl){
		dataWylotu = dataWyl;
	}
	public void setDataPrzylotu(String dataPrzyl){
		dataPrzylotu = dataPrzyl;
	}
	public void setDataWylotuOrazPrzylotu(String dataWyl, String dataPrzyl){
		dataWylotu = dataWyl;
		dataPrzylotu = dataPrzyl;
	}
	public void setSamolotObslugujacyLot(Samolot sam){
		samolot = sam;
	}
	
	// metoda do wyswietlania informacji o locie
		public void wyswietlInfoLotu(){
			System.out.println("Numer lotu    : " + numerLotu);
			System.out.println("Lot relacji   : " + this.getPoczatekTrasy() + "-" + this.getKoniecTrasy());
			System.out.println("Data wylotu   : " + this.getDataWylotu());
			System.out.println("Data przylotu : " + this.getDataPrzylotu());
			System.out.println("Typ samolotu  : " + this.samolot.getModelSamolotu());
		}
}
