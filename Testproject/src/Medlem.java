

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
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
		String k�n = "";
		if (this.isGender()) {
			k�n = "mand";
		} else {
			k�n = "kvinde";
		}
		String s = medlemsnummer + " | " + navn + " | " + Medlem.getAlder(this.getFoedselsdag()) + " | " + k�n + " | " + harBetalt;
		return s;
	}

	public static ArrayList<Medlem> opretMedlem(ArrayList<Medlem> medlemmer) throws Exception {
		// TODO - implement Delfinen.opretMedlem
		Scanner sc = new Scanner(System.in);
		System.out.println("indtast medlemsnavn: ");
		String navn = sc.nextLine();
		System.out.println(" indtast f�dselsdag som YYYY-MM-DD: ");
		//DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		String date = sc.next();

		//convert String to LocalDate
		LocalDate bday = LocalDate.parse(date);

		System.out.println(" indtast k�n: M/K: ");
		boolean gender = false;
		if (sc.next().equalsIgnoreCase("M")) {
			gender = true;
		}
		System.out.println(" Har medlem betalt? [J/N]");
		boolean harBetalt = false;
		if (sc.next().equalsIgnoreCase("J")) {
			harBetalt = true;
		}
		System.out.println("�nsker du at v�re aktivt medlem? [J/N]");
		if (sc.next().equalsIgnoreCase("N")) {
			Medlem nytmedlem = new PassivMedlem(navn, bday, gender, harBetalt);
			nytmedlem.setType("PassivMedlem");
			Medlem.skrivMedlemmerTilFil(nytmedlem);
			medlemmer.add(nytmedlem);
			return medlemmer;
		}
		System.out.println("�nsker du at v�re konkurrencesv�mmer? [J/N]");
		if (sc.next().equalsIgnoreCase("n")) {
			Medlem nytmedlem = new Medlem(navn, bday, gender, harBetalt);
			nytmedlem.setType("Medlem");
			Medlem.skrivMedlemmerTilFil(nytmedlem);
			medlemmer.add(nytmedlem);
			return medlemmer;
		}
		String aktivdisciplin = "";
		System.out.println("tast de discipliner du vil stille op i, uden komma i mellem: ");
		System.out.println("brystsv�mnin=b, crawl=c, ryg=r, butterfly=f");
		aktivdisciplin = aktivdisciplin.concat(sc.next());

		Medlem nytmedlem = new Konkurrencesv�mmer(navn, bday, gender, harBetalt, aktivdisciplin);
		nytmedlem.setType("Konkurrencesv�mmer");
		Medlem.skrivMedlemmerTilFil(nytmedlem);
		medlemmer.add(nytmedlem);
		return medlemmer;


		// tilf�j nyt medlem til ArrayList


	}

	public int getMedlemsnummer() {
		return medlemsnummer;
	}

	public static void skrivMedlemmerTilFil(Medlem m) throws FileNotFoundException {
		File medlemsliste = new File("medlemsliste.txt");
		PrintStream medlemprint = new PrintStream(new FileOutputStream(medlemsliste, true));
		medlemprint.println(m);

	}
}

