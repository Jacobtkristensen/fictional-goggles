

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

	public static ArrayList<Medlem> opretMedlem(ArrayList<Medlem> medlemmer) throws Exception {
		// TODO - implement Delfinen.opretMedlem
		Scanner sc = new Scanner(System.in);
		System.out.println("indtast medlemsnavn: ");
		String navn = sc.nextLine();
		System.out.println(" indtast fødselsdag som YYYY-MM-DD: ");
		//DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		String date = sc.next();

		//convert String to LocalDate
		LocalDate bday = LocalDate.parse(date);

		System.out.println(" indtast køn: M/K: ");
		boolean gender = false;
		if (sc.next().equalsIgnoreCase("M")) {
			gender = true;
		}
		System.out.println(" Har medlem betalt? [J/N]");
		boolean harBetalt = false;
		if (sc.next().equalsIgnoreCase("J")) {
			harBetalt = true;
		}
		System.out.println("ønsker du at være aktivt medlem? [J/N]");
		if (sc.next().equalsIgnoreCase("N")) {
			Medlem nytmedlem = new PassivMedlem(navn, bday, gender, harBetalt);
			nytmedlem.setType("PassivMedlem");
			Medlem.skrivMedlemmerTilFil(nytmedlem);
			medlemmer.add(nytmedlem);
			return medlemmer;
		}
		System.out.println("ønsker du at være konkurrencesvømmer? [J/N]");
		if (sc.next().equalsIgnoreCase("n")) {
			Medlem nytmedlem = new Medlem(navn, bday, gender, harBetalt);
			nytmedlem.setType("Medlem");
			Medlem.skrivMedlemmerTilFil(nytmedlem);
			medlemmer.add(nytmedlem);
			return medlemmer;
		}
		String aktivdisciplin = "";
		System.out.println("tast de discipliner du vil stille op i, uden komma i mellem: ");
		System.out.println("brystsvømnin=b, crawl=c, ryg=r, butterfly=f");
		aktivdisciplin = aktivdisciplin.concat(sc.next());

		Medlem nytmedlem = new Konkurrencesvømmer(navn, bday, gender, harBetalt, aktivdisciplin);
		nytmedlem.setType("Konkurrencesvømmer");
		Medlem.skrivMedlemmerTilFil(nytmedlem);
		medlemmer.add(nytmedlem);
		return medlemmer;


		// tilføj nyt medlem til ArrayList


	}

	public int getMedlemsnummer() {
		return medlemsnummer;
	}

	public static void skrivMedlemmerTilFil(Medlem m) throws FileNotFoundException {
		File medlemsliste = new File("medlemsliste.txt");
		PrintStream medlemprint = new PrintStream(new FileOutputStream(medlemsliste, true));
		medlemprint.println(m);

	}
	public static ArrayList<Medlem> indlæsMedlemmer() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("medlemsliste.txt"));
		ArrayList<Medlem> medlemmer = new ArrayList<>();
		int antalMedlemmer;
		int medlemnr;
		String medlemnavn;
		LocalDate bday;
		boolean isMale;
		String memberType;
		double fee;
		boolean hasPaid;
		String line = "";
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			Scanner nsc = new Scanner(line);
			while (nsc.hasNext()) {
				antalMedlemmer = nsc.nextInt();
				medlemnr = nsc.nextInt();
				medlemnavn = nsc.next();
				bday = LocalDate.parse(nsc.next());
				isMale = nsc.nextBoolean();
				memberType = nsc.next();
				fee = nsc.nextDouble(); //int medlemsnummer, String navn, LocalDate foedselsdag, boolean gender, String type, double kontingent, boolean harBetalt
				hasPaid = nsc.nextBoolean();
				if (memberType.equals("Medlem") || memberType.equals("PassivMedlem")) {
					Medlem nytMedlem = new Medlem(medlemnr, medlemnavn, bday, isMale, memberType, fee, hasPaid);
					medlemmer.add(nytMedlem);
				} else {
					boolean[] a = new boolean[4];
					Svømmedisciplin[] s = new Svømmedisciplin[4];
					LocalTime[] res = new LocalTime[4];
					//nu skal der indlæses værdier i de forskellige arrays: hvordan får vi læst "udenom" [] og ,
					// jeg har overloadet constructorer i Medlem, Konkurence og svømmedisciplinklasse så jeg kan instantiere
					//nye objecter og tilføjer medlemmerArraylisten.

				}

			}


		}

	}
}

