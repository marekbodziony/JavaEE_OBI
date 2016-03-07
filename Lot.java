package OBI;


public class Lot {
	
	private String poczatekTrasy;
	private String koniecTrasy;
	private String dataWylotu;
	private String dataPrzylotu;
	private Samolot samolot;
	
	public Lot(String poczTrasy, String konTrasy, String dataWyl, String dataPrzyl,Samolot sam){
		
		poczatekTrasy = poczTrasy;
		koniecTrasy = konTrasy;
		dataWylotu = dataWyl;
		dataPrzylotu = dataPrzyl;
		samolot = sam;
	}

	// metoda do wyswietlania informacji o locie
	public void wyswietlInfoLotu(){
		System.out.println("Lot relacji   : " + this.getPoczatekTrasy() + "-" + this.getKoniecTrasy());
		System.out.println("Data wylotu   : " + this.getDataWylotu());
		System.out.println("Data przylotu : " + this.getDataPrzylotu());
		System.out.println("Typ samolotu  : " + this.samolot.getModelSamolotu());
	}
	
	// getters
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
}
