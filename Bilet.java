package OBI;

import java.util.Date;

public class Bilet {
	
	private String poczatekTrasy;
	private String koniecTrasy;
	private Date dataPodrozy;
	private String numerMiejsca;
	private float cenaBiletu;
	
	public Bilet(String poczatekTr, String koniecTr,Date dataPodr, String miejsceNr, float cena){
		
		poczatekTrasy = poczatekTr;
		koniecTrasy = koniecTr; 
		dataPodrozy = dataPodr;
		numerMiejsca = miejsceNr;
		cenaBiletu = cena;
	}

}
