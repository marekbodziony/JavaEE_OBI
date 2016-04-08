package OBI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Lot {
	
	private String numerLotu;
	private Lotnisko miejsceWylotu;
	private Lotnisko miejscePrzylotu;
	private float dlugoscTrasy;
	private GregorianCalendar dataWylotu;
	private GregorianCalendar dataPrzylotu;
	private int maksymalnaLiczbaPasazerow;
	private List<Bilet> listaBiletow = new ArrayList<Bilet>();
	
	// constructor	
	public Lot(String lotNr, Lotnisko miejsceWyl, Lotnisko miejscePrzyl, float dlugTrasy, GregorianCalendar dataWyl, GregorianCalendar dataPrzyl, int maksLiczbaPasazerow){
		
		numerLotu = lotNr;
		miejsceWylotu = miejsceWyl;
		miejscePrzylotu = miejscePrzyl;
		dlugoscTrasy = dlugTrasy;
		dataWylotu = dataWyl;
		dataPrzylotu = dataPrzyl;
		maksymalnaLiczbaPasazerow = maksLiczbaPasazerow;
	}

	// metoda do wyswietlania informacji o locie
	public void wyswietlInfoLotu(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		System.out.println("Numer lotu    : " + numerLotu);
		System.out.println("Lot relacji   : " + miejsceWylotu.getMiasto() + " (" + miejsceWylotu.getKodLotniska() + ") - " + 
					miejscePrzylotu.getMiasto() + " (" + miejscePrzylotu.getKodLotniska() + ")");
		System.out.println("Data wylotu   : " + sdf.format(dataWylotu.getTime()));
		System.out.println("Data przylotu : " + sdf.format(dataPrzylotu.getTime()));
		System.out.println("\nDlugosc trasy : " + dlugoscTrasy + " km");
		System.out.println("Maksymalna liczba pasazerow na ten lot : " + maksymalnaLiczbaPasazerow + " osob");
		System.out.println("Ilosc zarezerwowanych miejsc (biletow) : " + listaBiletow.size());
	}
	
	// metoda dodaje bilet do listy biletow danego lotu (jesli sa wolne miejsca)
	public void dodajBiletDoListy(Bilet nowyBilet){
		if (listaBiletow.size() < maksymalnaLiczbaPasazerow){ listaBiletow.add(nowyBilet);}
		else {System.out.println("Brak miejsc na dany lot");}
	}
	// metoda usuwa bilet z listy biletow danego lotu
	public void usunBiletZListy (Bilet bilet){
		boolean czyUsunietoBilet = false;
		for (int i = 0; i < listaBiletow.size(); i++){
			if(bilet.getNrBiletu().equals(listaBiletow.get(i).getNrBiletu())){
				listaBiletow.remove(i);
				bilet.setNumerMejsca(0);
				//System.out.println("Usunieto wpis z pozycji : " + (i+1));
				czyUsunietoBilet = true;
				break;
			}
		}
		 if (!czyUsunietoBilet) System.out.println("BLAD! Wskazany bilet nie jest przypisany do lotu");
	}
	// metoda do wyswietla liste biletow dla danego lotu
	public void wyswietlListeBiletow(){
		int i = 1;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		System.out.println("Lot: " + numerLotu + ", Trasa: " + miejsceWylotu.getMiasto() + " - " + miejscePrzylotu.getMiasto() + ", Data wylotu: " + sdf.format(dataWylotu.getTime()));
		if (listaBiletow.size() > 0){
			for (Bilet bilet : listaBiletow){
				System.out.println(i++ + ". " + bilet.getNrBiletu() + ", " + bilet.getPasazer().getImie() + ", " + bilet.getPasazer().getNazwisko() + " (" + bilet.getPasazer().getTypPasazera().name() +
						 "), Nr miejsca: " + bilet.getNrMiejsca() + "\t\t | Oplacony : " + bilet.getCzyBiletOplacony() + " | Odprawiony : " + bilet.getCzyBiltOdprawiony());
				
			}
		}
		else {System.out.println("- Brak biletow do wyswietlenia -");}
	}
	
	// getters
	public String getNumerLotu(){ return numerLotu; }
	public Lotnisko getMiejsceWylotu(){ return miejsceWylotu; }
	public Lotnisko getMiejscePrzylotu(){ return miejscePrzylotu; }
	public float getDlugoscTrasy(){ return dlugoscTrasy;}
	public GregorianCalendar getDataWylotu(){ return dataWylotu; }
	public GregorianCalendar getDataPrzylotu(){ return dataPrzylotu; }
	public int getMaksymalnaLiczbaPasazerow(){ return maksymalnaLiczbaPasazerow;}
	public List<Bilet> getListaBiletow(){ return listaBiletow;}
	
	// setters
	public void setNumerLotu(String lotNr){ numerLotu = lotNr; }
	public void setMiejsceWylotu(Lotnisko miejsceWyl){ miejsceWylotu = miejsceWyl; }
	public void setMiejscePrzylotu(Lotnisko miejscePrzyl){ miejscePrzylotu = miejscePrzyl; }
	public void setDlugoscTrasy(float dlugTrasy){ dlugoscTrasy = dlugTrasy;}
	public void setDataWylotu(GregorianCalendar dataWyl){ dataWylotu = dataWyl; }
	public void setDataPrzylotu(GregorianCalendar dataPrzyl){ dataPrzylotu = dataPrzyl; }
}
