package OBI;


public class Samolot {
	
	private String modelSamolotu;
	private int liczbaMiejsc;
	private String dataProdukcji;
	private String dataOstatniegoPrzegladu;
	
	// konstruktor
	public Samolot(String model, int ilMiejsc, String rokProd, String ostPrzegl){
		
		modelSamolotu = model;
		liczbaMiejsc = ilMiejsc;
		dataProdukcji = rokProd;
		dataOstatniegoPrzegladu = ostPrzegl;
	}
		
	// getters
	public String getModelSamolotu(){
		return modelSamolotu;
	}
	public int getLiczbaMiejsc(){
		return liczbaMiejsc;
	}
	public String getDataProdukcji(){
		return dataProdukcji;
	}
	public String getDatOstatniegoPrzegladu(){
		return dataOstatniegoPrzegladu;
	}
	
	// setters
	public void setDataOstatniegoPrzeglądu (String dataPrzegladu){
		dataOstatniegoPrzegladu = dataPrzegladu;
	}
	
	// metoda do wyswietlania informacji o samolocie
		public void wyswietlSzczegolySamolotu(){
			
			System.out.println("Model samolotu : " + this.getModelSamolotu());
			System.out.println("Ilość miejsc   : " + this.getLiczbaMiejsc());
			System.out.println("Data produkcji : " + this.getDataProdukcji());
			System.out.println("Data przeglądu : " + this.getDatOstatniegoPrzegladu());
		}
}
