package com.hanze.kantine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persoon {

	private String BSN;
	private String voornaam;
	private String achternaam;
	private Datum geboorteDatum;
	private char geslacht;
	private Betaalwijze betaalwijze;

	public Persoon(String BSN, String voornaam, String achternaam) {
		this.BSN = BSN;
		this.voornaam = voornaam;
		this.achternaam = achternaam;

		this.geboorteDatum = new Datum(0, 0, 0);
		this.geslacht = 'u';
	}

	public Persoon(String BSN, String voornaam, String achternaam, Datum geboorteDatum, char geslacht) {
		this.BSN = BSN;
		this.voornaam = voornaam;
		this.achternaam = achternaam;

		setGeboorteDatum(geboorteDatum);
		setGeslacht(geslacht);
	}

	public String getBSN() {
		return BSN;
	}

	public void setBSN(String BSN) {
		this.BSN = BSN;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getGeboorteDatum() {
		return geboorteDatum.getDatumAsString();
	}

	public void setGeboorteDatum(Datum geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public String getGeslacht() {
		if (geslacht == 'm') {
			return "man";
		} else if (geslacht == 'v') {
			return "vrouw";
		} else {
			return "Onbekend";
		}
	}

	public void setGeslacht(char geslacht) {
		if (geslacht != 'm' && geslacht != 'v') {
			this.geslacht = 'u';
			System.out.println("Dit is geen goed geslacht");
		} else {
			this.geslacht = geslacht;
		}
	}

    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
    }

    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    @Override
	public String toString() {
		return "Persoon{" +
				"BSN='" + BSN + '\'' +
				", voornaam='" + voornaam + '\'' +
				", achternaam='" + achternaam + '\'' +
				", geboorteDatum=" + geboorteDatum +
				", geslacht=" + geslacht +
				'}';
	}
}
