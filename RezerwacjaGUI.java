package OBI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import OBI.Pasazer.TypPasazera;

public class RezerwacjaGUI extends JFrame {
	
	// Baza lotnisk
		Lotnisko londynHeathrow = new Lotnisko("Heathrow Airport", "HTR", "Londyn", "Wielka Brytania");
		Lotnisko wawaChopin = new Lotnisko("Warsaw Chopin Airport", "WAW", "Warszawa", "Polska");
		Lotnisko wawaModlin = new Lotnisko("Warsaw Modlin Airport", "WMI", "Modlin", "Polska");
		Lotnisko chicagoOhare = new Lotnisko("O’Hare International Airport", "ORD", "Chicago", "Stany Zjednoczone");
	
	// Baza dostępnych lotów
		Lot wawaChop_chicago = new Lot("LO3923", wawaChopin, chicagoOhare, 7512.74f, new GregorianCalendar(2016,04,20, 14,35), new GregorianCalendar(2016,04,20, 15,50), 150);
		Lot chicago_londyn = new Lot("WI1087", chicagoOhare, londynHeathrow, 6356.69f, new GregorianCalendar(2016,05,13, 05,00), new GregorianCalendar(2016,05,13, 12,30), 190);
		Lot londyn_wawaChop = new Lot("LO2205", londynHeathrow, wawaChopin, 1447.45f, new GregorianCalendar(2016,05,13, 18,00),new GregorianCalendar(2016,05,13, 20,10), 180);
		Lot wawaMod_londyn = new Lot("FR1730", wawaModlin, londynHeathrow, 1448.29f, new GregorianCalendar(2016,06,01, 17,00), new GregorianCalendar(2016,06,01, 18,20), 120);

		Lot lot1 = wawaChop_chicago;
		Lot lot2 = chicago_londyn;
		Lot lot3 = londyn_wawaChop;
		Lot lot4 = wawaMod_londyn;
		Lot wybranyLot = lot1;		// konieczne przypisane dowolnego lotu dla dzialania programu (pozniej bedzie zmieniony na lot wybrany z listy)
		Bilet aktualnyBilet;		// konieczne przypisane dowolnego biletu dla dzialania programu (pozniej bedzie zmieniony na bilet)
		
	// Baza pasazerow
		Pasazer p1 = new Pasazer("Marek","Bodziony",TypPasazera.MR);
		Pasazer p2 = new Pasazer("Nikodem","Bodziony",TypPasazera.CHLD);
		Pasazer p3 = new Pasazer("Janina", "Kowalska",TypPasazera.MRS);
		Pasazer p4 = new Pasazer("Ania","Kowalska",TypPasazera.INF);
		
			
	// elementy wyciagniete na zewnatrz konstruktora zeby mozna bylo je 'obsluzyc' przez inne elementy programu
		Lot [] listaLotowDoWysw = new Lot [4];
		Bilet [] listaBiletowLotDoWysw;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy  hh:mm a");
		JList<Lot> listaLotow;
		JTextField nrLotuText;
		JTextField trasaLotuText;
		JTextField dataWylText;
		JTextField dataPrzylText;
		JTextField dlTrasyText;
		JTextField maxIloscPasazerowText;
		JTextField iloscWolnychMiejscText;
		JTextField czyZrealizowanyText;
		JList<Bilet> listaBiletowInfoLotu;
		JScrollPane listaBiletowSuwakInfoLotu;
		JButton zrealizujLotButton;
		JLabel tytulBiletLabel;
		JTextField pasazerBiletText;
		JTextField lotNrBiletText;
		JTextField trasaBiletText;
		JTextField dataWylBiletText;
		JTextField dataPrzylBiletText;
		JTextField cenaBiletText;
		JButton oplacBiletButton;
		JButton odprawBiletButton;
	

	public RezerwacjaGUI(){
		
	// lista lotow do wyswietlenia jako tablica Object[] dla JList<Lot>
		listaLotowDoWysw[0] = lot1;
		listaLotowDoWysw[1] = lot2;
		listaLotowDoWysw[2] = lot3;
		listaLotowDoWysw[3] = lot4;
		
	// --------- generuje rezerwacje na lot1 dla pasazerow p1 i p2 -------------------------------
	for (int i = 0; i < 150;i++){
		RezerwujBilet.rezerwujBilet(lot1,p1);
		if (i%3==0) lot1.getListaBiletow().get(i).dodajBagaz(new Bagaz(13));
		RezerwujBilet.oplacBilet(lot1.getListaBiletow().get(i));
		RezerwujBilet.odprawBilet(lot1.getListaBiletow().get(i));
	}
	for (int i = 0; i < 100;i++){
		RezerwujBilet.rezerwujBilet(lot2,p3);
		if (i%2==0) RezerwujBilet.oplacBilet(lot2.getListaBiletow().get(i));
		if (i%4==0) RezerwujBilet.odprawBilet(lot2.getListaBiletow().get(i));
	}
	// ----------------------------------------------------------------------------------------------
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("System Rezerwacji Biletow");
	
	JPanel glownyPanel = new JPanel();	// glowne okno systemu rezerwacji biletow
	
	// --- panel "Strony logowania" -------------------------------------------------------------- STRONA LOGOWANIA (panel) --------------------		
	JPanel panelLogowania = new JPanel();
	JPanel login = new JPanel();
	JPanel haslo = new JPanel();
	JPanel zaloguj = new JPanel();
	
	// --- panel "Glowne okno" systemu ------------------------------------------------------------ GLOWNE OKNO (panel) ---------------------
	JPanel panelGlowneOknoSystemu = new JPanel();
	panelGlowneOknoSystemu.setVisible(false);
	JPanel panelGlowneOknoListaLotow = new JPanel();
	JPanel panelGlowneOknoPrzyciski = new JPanel();
	
	// --- panel "Info o locie" ------------------------------------------------------------------- INFO O LOCIE (panel) -----------------------
	JPanel infoLotu = new JPanel();
	infoLotu.setVisible(false);
	JPanel szczegolyInfoLotu = new JPanel();
	JPanel panelListaBiletowInfoLotu = new JPanel();
	
	// --- panel "Rezerwuj lot" ------------------------------------------------------------------- REZERWUJ LOT (panel) -------------------------
	JPanel panelRezerwuj = new JPanel();
	panelRezerwuj.setVisible(false);
	JPanel panelRezerwujDanePasazera = new JPanel();
	JPanel panelRezerwujCena = new JPanel();
	JPanel panelRezerwujPrzyciski = new JPanel();
	
	// --- panel "Bilet" --------------------------------------------------------------------------- BILET (panel) ---------------------------------
	JPanel panelBilet = new JPanel();
	panelBilet.setVisible(false);
	JPanel panelBiletPasazer = new JPanel();
	JPanel panelBiletLot = new JPanel();
	JPanel panelBiletCena = new JPanel();
	JPanel panelBiletPrzyciski = new JPanel();
	
	
	// --------- elementy panelu "Strony logowania" ----------------------------------------------- STRONA LOGOWANIA (elementy) ------------------
	JLabel nazwaNaPaneluLogowania = new JLabel("SYSTEM REZERWACJI BILETOW");
	nazwaNaPaneluLogowania.setFont(new Font("",1,25));
	JLabel loginLabel = new JLabel("login : ");
	JTextField loginText = new JTextField (10);
	JLabel hasloLabel = new JLabel("haslo : ");
	JPasswordField hasloText = new JPasswordField (10);
	JButton loginButton = new JButton("ZALOGUJ");			// -------------------------------------- przycisk ZALOGUJ
	loginButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			panelLogowania.setVisible(false);
			panelGlowneOknoSystemu.setVisible(true);	
			//panelBilet.setVisible(true);				// DO TESTOWANIA !!!!?????@@@
			System.out.println("Zalogowano uzytkownika : " + loginText.getText());
		}
	});
	
	// ----------- elementy panelu "Glownego okna" -------------------------------------------------- GLOWNE OKNO (elementy) ------------------------
	JLabel nazwaNaPaneluRezerwacji = new JLabel("SYSTEM REZERWACJI BILETOW");
	nazwaNaPaneluRezerwacji.setFont(new Font("",1,25));
	// po wybraniu "Wyswietl lot" pojawia sie panel z informacjami o wybranym locie i lista biletow
	JButton wyswietlLotButton = new JButton("Wyswietl Lot");		// ------------------------------- przycisk WYSWIETL LOT
	wyswietlLotButton.setEnabled(false);
	wyswietlLotButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			System.out.println("Wyswietl info o locie");
			listaLotow.getSelectedValue().wyswietlInfoLotu();
			// widoczny panel z informacjami o locie
			infoLotu.setVisible(true);
			// niewidoczny panel do rezerwacji
			panelGlowneOknoSystemu.setVisible(false);
			// ustawiane sa wartosci pol do wyswietlenia na panelu "Info o locie" (informacje pobrane z wybranego z listy lotu)
			nrLotuText.setText(listaLotow.getSelectedValue().getNumerLotu());
			trasaLotuText.setText(listaLotow.getSelectedValue().getMiejsceWylotu().getKodLotniska() + " - " + listaLotow.getSelectedValue().getMiejscePrzylotu().getKodLotniska());
			dataWylText.setText(sdf.format(listaLotow.getSelectedValue().getDataWylotu().getTime()));
			dataPrzylText.setText(sdf.format(listaLotow.getSelectedValue().getDataPrzylotu().getTime()));
			dlTrasyText.setText(listaLotow.getSelectedValue().getDlugoscTrasy() + " km");
			maxIloscPasazerowText.setText(""+listaLotow.getSelectedValue().getMaksymalnaLiczbaPasazerow());
			iloscWolnychMiejscText.setText("" + (listaLotow.getSelectedValue().getMaksymalnaLiczbaPasazerow()-listaLotow.getSelectedValue().getListaBiletow().size()));
			// jesli lot zostal juz zrealizowany to 'wylacz' przycisk ZREALIZUJ LOT i zmien kolor tekstu
			if (listaLotow.getSelectedValue().getCzyLotZrealizowany()) { czyZrealizowanyText.setText("TAK"); czyZrealizowanyText.setForeground(Color.ORANGE); zrealizujLotButton.setEnabled(false);}
			else {czyZrealizowanyText.setText("NIE"); czyZrealizowanyText.setForeground(Color.BLUE); zrealizujLotButton.setEnabled(true);}
			// uzupelnia tablice biletami z wybranego lotu, zeby je wyswietlic na liscie w "Info o locie"
			listaBiletowLotDoWysw = new Bilet [listaLotow.getSelectedValue().getListaBiletow().size()];
			for (int i = 0; i < listaBiletowLotDoWysw.length; i++){ 	
				listaBiletowLotDoWysw[i] = listaLotow.getSelectedValue().getListaBiletow().get(i);
			}
			// ustawienia wyswietlania listy biletow danego lotu ------------------------------ Lista biletow danego lotu JList<Bilet> 
			listaBiletowInfoLotu = new JList<Bilet>(listaBiletowLotDoWysw);
			listaBiletowInfoLotu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaBiletowInfoLotu.setLayoutOrientation(JList.VERTICAL);
			listaBiletowInfoLotu.setCellRenderer(new ListaBiletowInfoLotuRenderer());
			listaBiletowSuwakInfoLotu = new JScrollPane(listaBiletowInfoLotu);
			listaBiletowSuwakInfoLotu.setPreferredSize(new Dimension(700, 250));
			panelListaBiletowInfoLotu.add(listaBiletowSuwakInfoLotu);
		}
	});
	JButton rezerwujLotButton = new JButton("Rezerwuj Lot");	// --------------------------- Przycisk REZERWUJ LOT 
	rezerwujLotButton.setEnabled(false);
	rezerwujLotButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			panelRezerwuj.setVisible(true);
			panelGlowneOknoSystemu.setVisible(false);
		}
	});
	// ustawienia wyswietlania listy wszystkich dostepnych lotow ------------------------------ Lista dostepnych lotow JList<Lot> 
	listaLotow = new JList<Lot>(listaLotowDoWysw);
	listaLotow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	listaLotow.setLayoutOrientation(JList.VERTICAL);
	listaLotow.setCellRenderer(new ListaLotowRenderer());
	listaLotow.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		public void valueChanged(ListSelectionEvent event) {
			if (event.getValueIsAdjusting() == false){
				// jesli zostal wybrany lot na liscie to 'wlacz' przycisk do wyswietlania info o locie
				if (listaLotow.getSelectedIndex() >= 0){
					wybranyLot = listaLotow.getSelectedValue();
					wyswietlLotButton.setEnabled(true);
					// jesli sa jeszcze wolne miejsca i lot nie zostal zrealizowany to 'wlacz' przycisk do rezerwacji lotu
					if (wybranyLot.getListaBiletow().size() < wybranyLot.getMaksymalnaLiczbaPasazerow() && !wybranyLot.getCzyLotZrealizowany()){rezerwujLotButton.setEnabled(true);}
					else {rezerwujLotButton.setEnabled(false);}
				}
				// jesli zaden lot nie zostal wybrany z listy to 'wylacz' przyciski do wyswietlania info o locie i rezerwacji
				else{
					wyswietlLotButton.setEnabled(false);
					rezerwujLotButton.setEnabled(false);
				}
			}
		} 
	});
	
	JButton wylogujButton = new JButton("WYLOGUJ");	  // -------------------------------------- Przycisk WYLOGUJ
	wylogujButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			System.out.println("- WYLOGOWANO -");
			loginText.setText("");
			hasloText.setText("");
			panelLogowania.setVisible(true);
			panelGlowneOknoSystemu.setVisible(false);
		}
	});
	
	// -------- elementy panelu "Info o locie" ------------------------------------------------- INFO O LOCIE (elementy) -------------------------
	JLabel nazwaPaneluInfoLotu = new JLabel("INFORMACJE O LOCIE :");
	JLabel nrLotuLabel = new JLabel ("Nr lot : ");
	nrLotuText = new JTextField(10);
	nrLotuText.setEditable(false);
	JLabel trasaLotuLabel = new JLabel("Lot relacji : ");
	trasaLotuText = new JTextField(10);
	trasaLotuText.setEditable(false);
	JLabel dataWylLabel = new JLabel("Data wylotu : ");
	dataWylText = new JTextField (10);
	dataWylText.setEditable(false);
	JLabel dataPrzylLabel = new JLabel("Data przylotu : ");
	dataPrzylText = new JTextField(10);
	dataPrzylText.setEditable(false);
	JLabel dlTrasyLabel = new JLabel("Dlugosc trasy : ");
	dlTrasyText = new JTextField(10);
	dlTrasyText.setEditable(false);
	JLabel maxIloscPasazLabel = new JLabel("Ilosc wszystkich miejsc : ");
	maxIloscPasazerowText = new JTextField();
	maxIloscPasazerowText.setEditable(false);
	JLabel iloscWolnychMiejscLabel = new JLabel("Wolnych miejsc : ");
	iloscWolnychMiejscText = new JTextField(10);
	iloscWolnychMiejscText.setEditable(false);
	JLabel czyZrealizowanyLabel = new JLabel("Czy lot zrealizowany : ");
	czyZrealizowanyText = new JTextField(10);
	czyZrealizowanyText.setEditable(false);
		
	JButton powrotInfoButton = new JButton("Powrot");		// ----------------------------------- Przycisk POWROT (do Glownego okna)
	powrotInfoButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			panelGlowneOknoSystemu.setVisible(true);
			infoLotu.setVisible(false);
			//panelListaBiletowInfoLotu.remove(listaBiletowInfoLotu);
			panelListaBiletowInfoLotu.remove(listaBiletowSuwakInfoLotu);
		}
	});
	zrealizujLotButton = new JButton("ZREALIZUJ LOT");		// ---------------------------------Przycisk ZREALIZUJ LOT 
	zrealizujLotButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			wybranyLot.zrealizujLot();
			//System.out.println("Zrealizowano lot " + wybranyLot.getNumerLotu());
			rezerwujLotButton.setEnabled(false);
			panelGlowneOknoSystemu.setVisible(true);
			infoLotu.setVisible(false);
			panelListaBiletowInfoLotu.remove(listaBiletowSuwakInfoLotu);
		}
	});
	
	
	
	// -------- elementy panelu "Rezerwuj Lot" --------------------------------------------------- REZERWUJ LOT (elementy) ----------------------
	JLabel rezerwujLotLabel = new JLabel("REZERWUJ LOT");
	String infoLotuDoWyswietlenia = "Lot : " + wybranyLot.getNumerLotu() + "   " + wybranyLot.getMiejsceWylotu().getKodLotniska() + "  -  " + 
									wybranyLot.getMiejscePrzylotu().getKodLotniska() + "  Data wylotu:  " + sdf.format(wybranyLot.getDataWylotu().getTime());
	JLabel infoLotuRezerwujLabel = new JLabel(infoLotuDoWyswietlenia);
	JLabel imieRezerwujLabel = new JLabel("Imie : ");
	JTextField imieRezerwujText = new JTextField();
	JLabel nazwiskoRezerwujLabel = new JLabel("Nazwisko : ");
	JTextField nazwiskoRezerwujText = new JTextField();
	JLabel typRezerwujLabel = new JLabel("Typ : ");
	JComboBox <Pasazer.TypPasazera> typRezerwujComboBox = new JComboBox <Pasazer.TypPasazera> (new Pasazer.TypPasazera [] {Pasazer.TypPasazera.MR, Pasazer.TypPasazera.MRS, 
			Pasazer.TypPasazera.CHLD, Pasazer.TypPasazera.INF});
	JLabel bagazRezerwujLabel = new JLabel("Bagaz : ");
	JCheckBox bagazRezerwujCheckBox = new JCheckBox();
	JLabel cenaRezerwujLabel = new JLabel("CENA = ");
	JTextField cenaRezerwujText = new JTextField(5);
	cenaRezerwujText.setEditable(false);
	cenaRezerwujText.setText("0");
	JButton anulujRezerwujButton = new JButton("Anuluj");			// ----------------------------- Przycisk ANULUJ 
	anulujRezerwujButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			panelGlowneOknoSystemu.setVisible(true);
			panelRezerwuj.setVisible(false);
			// czysci dane pasazera
			imieRezerwujText.setText("");
			nazwiskoRezerwujText.setText("");
			typRezerwujComboBox.setSelectedIndex(0);
			cenaRezerwujText.setText("0");
		}
	});
	JButton przeliczRezerwujButton = new JButton("Przelicz");	// -----------------------------------Przycisk PRZELICZ
	przeliczRezerwujButton.addActionListener(new ActionListener(){
		public void actionPerformed (ActionEvent event){
			// przelicza cene biletu na dany lot (na podstawie lotu, typu pasazera oraz czy ma bagaz)
			Bilet b = new Bilet(wybranyLot,new Pasazer("","",(Pasazer.TypPasazera)typRezerwujComboBox.getSelectedItem()));
			b.setCzyRezerwacjaAktywna(true);
			if (bagazRezerwujCheckBox.isSelected()) {b.dodajBagaz(new Bagaz());}
			cenaRezerwujText.setText(b.getCenaBiletu() + " \u20AC"); 
			System.out.println("Przeliczam cene! Aktualna cena to : " + b.getCenaBiletu() + " \u20AC");

		}
	});
	JButton rezerwujRezerwujButton = new JButton("REZERWUJ");		// ------------------------------------------- Przycisk REZERWUJ (!!!) 
	rezerwujRezerwujButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			// rezerwuj bilet jesli podano prawidlowe dane (imie i nazwisko musi miec przynajmniej 1 znak)
			if ((imieRezerwujText.getText().length() > 0) && (nazwiskoRezerwujText.getText().length() > 0)){
				// tworzy nowego pasazera (p) ktoremy zarezerwujemy bilet na wskazany lot
				Pasazer p = new Pasazer(imieRezerwujText.getText(), nazwiskoRezerwujText.getText(), (Pasazer.TypPasazera)typRezerwujComboBox.getSelectedItem());
				// rezerwuje bilet dla pasazera (p) na wybrany lot
				Bilet b = RezerwujBilet.rezerwujBilet(wybranyLot,p);
				aktualnyBilet = b;
				if (bagazRezerwujCheckBox.isSelected()) {b.dodajBagaz(new Bagaz());}
				System.out.println("Zarezerwowano bilet dla : " + p.getImie() + " " + p.getNazwisko() + " (" + p.getTypPasazera().name() + ") na lot " + wybranyLot.getNumerLotu());
				System.out.println("Oplac bilet. Cena to " + b.getCenaBiletu() + " \u20AC");
				// bilet zostal zarezerwowany, czyscimy teraz wszystkie pola i idziemy do panelu biletu
				imieRezerwujText.setText("");
				nazwiskoRezerwujText.setText("");
				typRezerwujComboBox.setSelectedIndex(0);
				cenaRezerwujText.setText("0");
				panelRezerwuj.setVisible(false);
				//panelGlowneOknoSystemu.setVisible(true);
				// otwieramy panel nowego biletu i wyswietlamy informacje o bilecie
				panelBilet.setVisible(true);
				if(!aktualnyBilet.getCzyBiletOplacony()) {oplacBiletButton.setEnabled(true);}
				else {oplacBiletButton.setEnabled(false);}
				if (!aktualnyBilet.getCzyBiletOdprawiony()) {odprawBiletButton.setEnabled(true);}
				else {odprawBiletButton.setEnabled(false);}
				tytulBiletLabel.setText("Bilet o nr " + b.getNrBiletu());
				pasazerBiletText.setText(b.getPasazer().getImie() + " " + b.getPasazer().getNazwisko() + ", " + b.getPasazer().getTypPasazera().name());
				lotNrBiletText.setText(b.getLot().getNumerLotu());
				trasaBiletText.setText(b.getLot().getMiejsceWylotu().getKodLotniska() + " - " + b.getLot().getMiejscePrzylotu().getKodLotniska() );
				dataWylBiletText.setText(sdf.format(b.getLot().getDataWylotu().getTime()));
				dataPrzylBiletText.setText(sdf.format(b.getLot().getDataPrzylotu().getTime()));
				cenaBiletText.setText(b.getCenaBiletu() + "\u20AC");
			}
			else{
				System.out.println("Blad! Popraw dane i sprobuj jeszcze raz!");
			}
		}
	});
	
	// -------- elementy panelu "Bilet" ------------------------------------------------------------------ BILET (elementy) ----------------------------
	tytulBiletLabel = new JLabel("Bilet o nr .......");
	JLabel pasazerBiletLabel = new JLabel("Pasazer : ");
	pasazerBiletText = new JTextField(10);
	pasazerBiletText.setEditable(false);
	JLabel lotNrBiletLabel = new JLabel("Lot nr : ");
	lotNrBiletText = new JTextField();
	lotNrBiletText.setEditable(false);
	JLabel trasaBiletLabel = new JLabel("Trasa : ");
	trasaBiletText = new JTextField();
	trasaBiletText.setEditable(false);
	JLabel dataWylBiletLabel = new JLabel ("Data wylotu :");
	dataWylBiletText = new JTextField();
	dataWylBiletText.setEditable(false);
	JLabel dataPrzylBiletLabel = new JLabel ("Data wylotu :");
	dataPrzylBiletText = new JTextField();
	dataPrzylBiletText.setEditable(false);
	JLabel cenaBiletLabel = new JLabel("CENA = ");
	cenaBiletText = new JTextField(5);
	cenaBiletText.setEditable(false);
	JButton usunBiletButton = new JButton("USUN BILET");		// ---------------------------------------- Przycisk USUN
	usunBiletButton.setForeground(Color.RED);
	usunBiletButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			RezerwujBilet.anulujBilet(aktualnyBilet);
			panelBilet.setVisible(false);
			panelGlowneOknoSystemu.setVisible(true);
		}
	});
	JButton zamknijBiletButton = new JButton("Zamknij");		// ---------------------------------------- Przycisk ZAMKNIJ
	zamknijBiletButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			panelBilet.setVisible(false);
			panelGlowneOknoSystemu.setVisible(true);
		}
	});
	oplacBiletButton = new JButton("Oplac bilet");		// ------------------------------------------------ Przycisk OPLAC
	oplacBiletButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			RezerwujBilet.oplacBilet(aktualnyBilet);
			oplacBiletButton.setEnabled(false);
		}
	});
	odprawBiletButton = new JButton("Odpraw");			// ------------------------------------------------- Przycisk ODPRAW
	odprawBiletButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			RezerwujBilet.odprawBilet(aktualnyBilet);
			odprawBiletButton.setEnabled(false);
		}
	});
	
	
	// ------ ulozenie elementow panelu "Strona logowania"	----------------------------------------------- STRONA LOGOWANIA (ulozenie) ------------------	
	panelLogowania.setLayout(new BoxLayout(panelLogowania,BoxLayout.PAGE_AXIS));
	panelLogowania.add(nazwaNaPaneluLogowania);
	panelLogowania.add(login);
	panelLogowania.add(haslo);
	panelLogowania.add(zaloguj);
	zaloguj.setLayout(new BorderLayout());
	
	login.add(loginLabel);
	login.add(loginText);
	haslo.add(hasloLabel);
	haslo.add(hasloText);
	zaloguj.add(loginButton, BorderLayout.LINE_END);
	
	
	// ------ ulozenie elementow panelu "Glowne okno" ---------------------------------------------- GLOWNE OKNO (ulozenie) ------------------------
	panelGlowneOknoSystemu.setLayout(new BoxLayout(panelGlowneOknoSystemu, BoxLayout.PAGE_AXIS));
	panelGlowneOknoSystemu.add(nazwaNaPaneluRezerwacji);
	panelGlowneOknoSystemu.add(panelGlowneOknoListaLotow);
	panelGlowneOknoSystemu.add(wylogujButton);
	panelGlowneOknoSystemu.add(infoLotu);
	
	panelGlowneOknoListaLotow.setLayout(new BoxLayout(panelGlowneOknoListaLotow,BoxLayout.PAGE_AXIS));
	panelGlowneOknoListaLotow.add(listaLotow);
	panelGlowneOknoListaLotow.add(panelGlowneOknoPrzyciski);
	panelGlowneOknoPrzyciski.add(wyswietlLotButton);
	panelGlowneOknoPrzyciski.add(rezerwujLotButton);
	
	// ------ ulozenie elementow panelu "Info o locie" --------------------------------------------- INFO O LOCIE (ulozenie) --------------------
	infoLotu.setLayout(new BoxLayout(infoLotu, BoxLayout.PAGE_AXIS));
	infoLotu.add(nazwaPaneluInfoLotu);
	infoLotu.add(szczegolyInfoLotu);
	infoLotu.add(panelListaBiletowInfoLotu);
	infoLotu.add(powrotInfoButton);
	infoLotu.add(zrealizujLotButton);
	szczegolyInfoLotu.setLayout(new GridLayout(8,2));
	szczegolyInfoLotu.add(nrLotuLabel);
	szczegolyInfoLotu.add(nrLotuText);
	szczegolyInfoLotu.add(trasaLotuLabel);
	szczegolyInfoLotu.add(trasaLotuText);
	szczegolyInfoLotu.add(dataWylLabel);
	szczegolyInfoLotu.add(dataWylText);
	szczegolyInfoLotu.add(dataPrzylLabel);
	szczegolyInfoLotu.add(dataPrzylText);
	szczegolyInfoLotu.add(dlTrasyLabel);
	szczegolyInfoLotu.add(dlTrasyText);
	szczegolyInfoLotu.add(maxIloscPasazLabel);
	szczegolyInfoLotu.add(maxIloscPasazerowText);
	szczegolyInfoLotu.add(iloscWolnychMiejscLabel);
	szczegolyInfoLotu.add(iloscWolnychMiejscText);
	szczegolyInfoLotu.add(czyZrealizowanyLabel);
	szczegolyInfoLotu.add(czyZrealizowanyText);
	
	// ------ ulozenie elementow panelu "Rezerwuj Lot" ------------------------------------------------- REZERWUJ LOT (ulozenie) ---------------------
	panelRezerwuj.setLayout(new BoxLayout(panelRezerwuj,BoxLayout.PAGE_AXIS));
	panelRezerwuj.add(rezerwujLotLabel);
	panelRezerwuj.add(infoLotuRezerwujLabel);
	panelRezerwuj.add(panelRezerwujDanePasazera);
	panelRezerwuj.add(panelRezerwujCena);
	panelRezerwuj.add(panelRezerwujPrzyciski);
	panelRezerwujDanePasazera.setLayout(new GridLayout(4,2));
	panelRezerwujDanePasazera.add(imieRezerwujLabel);
	panelRezerwujDanePasazera.add(imieRezerwujText);
	panelRezerwujDanePasazera.add(nazwiskoRezerwujLabel);
	panelRezerwujDanePasazera.add(nazwiskoRezerwujText);
	panelRezerwujDanePasazera.add(typRezerwujLabel);
	panelRezerwujDanePasazera.add(typRezerwujComboBox);
	panelRezerwujDanePasazera.add(bagazRezerwujLabel);
	panelRezerwujDanePasazera.add(bagazRezerwujCheckBox);
	panelRezerwujCena.add(cenaRezerwujLabel);
	panelRezerwujCena.add(cenaRezerwujText);
	panelRezerwujPrzyciski.add(anulujRezerwujButton);
	panelRezerwujPrzyciski.add(przeliczRezerwujButton);
	panelRezerwujPrzyciski.add(rezerwujRezerwujButton);
	
	// ------ ulozenie elementow panelu "Rezerwuj Lot" ------------------------------------------------- REZERWUJ LOT (ulozenie) ---------------------
	panelBilet.setLayout(new BoxLayout(panelBilet, BoxLayout.PAGE_AXIS));
	panelBilet.add(tytulBiletLabel);
	panelBilet.add(panelBiletPasazer);
	panelBilet.add(panelBiletLot);
	panelBilet.add(panelBiletCena);
	panelBilet.add(panelBiletPrzyciski);
	panelBiletPasazer.add(pasazerBiletLabel);
	panelBiletPasazer.add(pasazerBiletText);
	panelBiletLot.setLayout(new GridLayout(4,2));
	panelBiletLot.add(lotNrBiletLabel);
	panelBiletLot.add(lotNrBiletText);
	panelBiletLot.add(trasaBiletLabel);
	panelBiletLot.add(trasaBiletText);
	panelBiletLot.add(dataWylBiletLabel);
	panelBiletLot.add(dataWylBiletText);
	panelBiletLot.add(dataPrzylBiletLabel);
	panelBiletLot.add(dataPrzylBiletText);
	panelBiletCena.add(cenaBiletLabel);
	panelBiletCena.add(cenaBiletText);
	panelBiletPrzyciski.add(usunBiletButton);
	panelBiletPrzyciski.add(zamknijBiletButton);
	panelBiletPrzyciski.add(oplacBiletButton);
	panelBiletPrzyciski.add(odprawBiletButton);
	
	
	// ----- ogolene ustawienia panelu programu "System Rezerwacji Lotow" -----------------------------------------------------------------------------
	glownyPanel.add(panelLogowania);
	glownyPanel.add(panelGlowneOknoSystemu);
	glownyPanel.add(infoLotu);
	glownyPanel.add(panelRezerwuj);
	glownyPanel.add(panelBilet);
	getContentPane().add(glownyPanel);
	
	pack();
	setVisible(true);
	}
	
	//pomocnicza klasa do wyswietlania elementow listy lotow na panelu "Info o locie"
	private class ListaLotowRenderer extends JLabel implements ListCellRenderer{
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy  hh:mm a");
		@Override
		public Component getListCellRendererComponent(JList listaL, Object oLot, int pozL, boolean isSelected, boolean cellHasFocus) {
			Lot lot = (Lot)oLot;
			int liczbaWolnychMiejsc = lot.getMaksymalnaLiczbaPasazerow() - lot.getListaBiletow().size();
			String doWyswietleniaNaLiscie = (pozL+1) + ". " + lot.getNumerLotu() + "  :       " + lot.getMiejsceWylotu().getKodLotniska() + " - " 
								+ lot.getMiejscePrzylotu().getKodLotniska() + "        " + sdf.format(lot.getDataWylotu().getTime()) 
								+ "      Wolnych miejsc: " + liczbaWolnychMiejsc;
			if (liczbaWolnychMiejsc == 0) {}
			if(!lot.getCzyLotZrealizowany()){doWyswietleniaNaLiscie += "      - NIEZREALIZOWANY"; setForeground(Color.BLACK); }
			else {doWyswietleniaNaLiscie += "      - ZREALIZOWANY"; setForeground(Color.ORANGE); }
			
			setText(doWyswietleniaNaLiscie);
			if (isSelected){ 
				setBackground(listaL.getSelectionBackground());
	            setForeground(listaL.getSelectionForeground());
			}
			else{ 
				setBackground(listaL.getBackground());
	            //setForeground(listaL.getForeground());
			}
			setEnabled(listaL.isEnabled());
			setFont(listaL.getFont());
			setOpaque(true);
			
			return this;
		}
		
	}
	//pomocnicza klasa do wyswietlania elementow listy biletow na panelu "Info o locie"
	private class ListaBiletowInfoLotuRenderer extends JLabel implements ListCellRenderer{
		@Override
		public Component getListCellRendererComponent(JList listaB, Object oBilet, int pozBiletu, boolean isSelected, boolean cellHasFocus) {
			String doWyswietleniaNaLiscie, infoOBagazu, czyOdprawiony;
			doWyswietleniaNaLiscie = (pozBiletu+1) + ". " + ((Bilet)oBilet).getNrBiletu() + "   |   " + ((Bilet)oBilet).getPasazer().getImie() + "  " + ((Bilet)oBilet).getPasazer().getNazwisko() 
										+ ",  " + ((Bilet)oBilet).getPasazer().getTypPasazera().name() + "      Miejsce : " + ((Bilet)oBilet).getNrMiejsca() + ",      Cena : " 
										+ ((Bilet)oBilet).getCenaBiletu() + " \u20AC    Bagaz : ";
			if (((Bilet)oBilet).getBagaz() != null) {infoOBagazu = "TAK (" + ((Bilet)oBilet).getBagaz().getWagaBagazu() + " kg)";}
			else {infoOBagazu = "NIE";}
			if (((Bilet)oBilet).getCzyBiletOdprawiony()) {czyOdprawiony = "    |     ODPRAWIONY"; setForeground(Color.BLUE); }
			else {czyOdprawiony = "    |     NIEODPRAWIONY"; setForeground(Color.BLACK); }
			doWyswietleniaNaLiscie += infoOBagazu + czyOdprawiony;
			
			setText(doWyswietleniaNaLiscie);
			if (isSelected){
				setBackground(listaB.getSelectionBackground());
				setForeground(listaB.getSelectionForeground());
			}
			else{
				setBackground(listaB.getBackground());
				//setForeground(listaB.getForeground());
			}
			setEnabled(listaB.isEnabled());
			setFont(listaB.getFont());
			setOpaque(true);
			
			return this;
		}
	}
	
}
