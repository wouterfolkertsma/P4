package com.hanze.kantine;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Author Wouter Folkertsma
 * Datum 15-05-2019
 */
public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	/**
	 * @param dag
	 * @param maand
	 * @param jaar
	 */
	public Datum (int dag, int maand, int jaar) {
		if (!this.bestaatDatum(dag, maand, jaar)) {
			this.dag = 0;
			this.maand = 0;
			this.jaar = 0;
		} else {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	/**
	 * @param dag
	 * @param maand
	 * @param jaar
	 * @return boolean
	 */
	public boolean bestaatDatum(int dag, int maand, int jaar){
		if (dag < 1) {
			return false;
		}
		if (maand < 1 || maand > 12) {
			return false;
		}
		if (jaar < 1900 || jaar > 2100) {
			return false;
		}
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");

		try {
			dt.setLenient(false);
			dt.parse(dag + "-" + maand + "-" + jaar);
		} catch (ParseException e) {
			return false;
		}

		return true;
	}
	
	/**
	 * Getter voor Sting weergave van datum
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		if (!this.bestaatDatum(this.dag, this.maand, this.jaar)) {
			return "Onbekend";
		}
		return this.dag + "-" + this.maand + "-" + this.jaar;
	}
}
