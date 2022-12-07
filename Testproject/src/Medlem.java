

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Medlem implements Serializable {
	private static int medlemmer = 0;
	private int medlemsnummer;
	private String navn;
	private LocalDate foedselsdag;
	private boolean gender;
	private String type = "";
	private double kontingent = 0;
	private boolean harBetalt;

	//Constructors. no-arg constructor must be available
	public Medlem() {
		this.medlemsnummer = medlemmer + 1;
		medlemmer++;
		this.navn = "Fornavn";
		this.foedselsdag = LocalDate.now();
		this.gender = false;
		this.harBetalt = false;
		this.type = "medlem";
		this.kontingent = this.beregnKontingent();
	}

	public Medlem(String navn, LocalDate foedselsdag, boolean gender, boolean harBetalt) {
		medlemsnummer = medlemmer + 1;
		medlemmer++;
		this.navn = navn;
		this.foedselsdag = foedselsdag;
		this.gender = gender;
		this.harBetalt = harBetalt;
		this.kontingent = this.beregnKontingent();
	}

	public Medlem(int medlemsnummer, String navn, LocalDate foedselsdag, boolean gender, String type, double kontingent, boolean harBetalt) {
		this.medlemsnummer = medlemsnummer;
		medlemmer++;
		this.navn = navn;
		this.foedselsdag = foedselsdag;
		this.gender = gender;
		this.type = type;
		this.kontingent = kontingent;
		this.harBetalt = harBetalt;
	}

	public boolean isGender() {
		return gender;
	}

	public String getType() {
		return type;
	}

	public static int getMedlemmer() {
		return medlemmer;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param foedselsdag
	 */
	public static int getAlder(LocalDate foedselsdag) {
		// TODO - implement Medlem.getAlder

		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(foedselsdag.getYear(), foedselsdag.getMonth(), foedselsdag.getDayOfMonth());
		Period period = Period.between(birthday, today);
		return period.getYears();
	}

	public LocalDate getFoedselsdag() {
		return foedselsdag;
	}

	public boolean getHarBetalt() {
		return harBetalt;
	}

	public double beregnKontingent() {
		double rabat = 0.75;
		double kontingent = 1600;
		double kontingentUng = 1000;
		if (getAlder(getFoedselsdag()) > 60) {
			return rabat * kontingent;
		} else if (getAlder(getFoedselsdag()) < 18) {
			return kontingentUng;
		} else {
			return kontingent;
		}
	}

	public String toString() {
		String s = medlemmer + " " + medlemsnummer + " " + navn + " " + foedselsdag + " " + gender + " " + type + " " + kontingent + " " + harBetalt;
		return s;
	}

	public String printTilKonsol() {
		String køn = "";
		if (this.isGender()) {
			køn = "mand";
		} else {
			køn = "kvinde";
		}
		String s = medlemsnummer + " | " + navn + " | " + Medlem.getAlder(this.getFoedselsdag()) + " | " + køn + " | " + harBetalt;
		return s;
	}


	public int getMedlemsnummer() {
		return medlemsnummer;
	}
//Skriv til fil og indlæs fra fil

	}


