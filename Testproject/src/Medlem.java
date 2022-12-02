import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;


public class Medlem {
	private static int medlemmer=1;
	private int medlemsnummer;
	private String navn;
	private LocalDate foedselsdag;

	public boolean isGender() {
		return gender;
	}

	private boolean gender;

	private double kontingent = 0;
	private boolean harBetalt;

	public Medlem(String navn, LocalDate foedselsdag, boolean gender, boolean harBetalt){
		medlemsnummer=medlemmer;
		medlemmer++;
		this.navn=navn;
		this.foedselsdag = foedselsdag;
		this.gender=gender;
		this.harBetalt=harBetalt;
	}

	/**
	 * 
	 * @param foedselsdag
	 */
	public static int getAlder(LocalDate foedselsdag) {
		// TODO - implement Medlem.getAlder

		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(foedselsdag.getYear(),foedselsdag.getMonth(),foedselsdag.getDayOfMonth());
		Period period = Period.between(birthday, today);
		return period.getYears();
	}
	public LocalDate getFoedselsdag(){
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
		}
		else if (getAlder(getFoedselsdag()) < 18) {
			return kontingentUng;
		}
		else {
			return kontingent;
		}
	}
	public String toString(){
		String k�n="";
		if(this.isGender()){
			 k�n="mand";
		}
		else {
			k�n="kvinde";
		}
		String s=medlemsnummer+" | "+navn+" | "+Medlem.getAlder(this.getFoedselsdag())+ " | " +k�n+ " | " +harBetalt;
		return s;
	}

	public static ArrayList<Medlem> opretMedlem(ArrayList<Medlem> medlemmer) {
		// TODO - implement Delfinen.opretMedlem
		Scanner sc=new Scanner(System.in);
		System.out.println("indtast medlemsnavn: ");
		String navn= sc.next();
		System.out.println(" indtast f�dselsdag som YYYY-MM-DD: ");
		//DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		String date =sc.next();

		//convert String to LocalDate
		LocalDate bday = LocalDate.parse(date);


		System.out.println(" indtast k�n: M/K: ");
		boolean gender=false;
		if (sc.next().equalsIgnoreCase("M")){
			gender=true;
		}
		System.out.println(" Har medlem betalt? [J/N]");
		boolean harBetalt = false;
		if (sc.next().equalsIgnoreCase("J")){
			harBetalt = true;
		}
		System.out.println("�nsker du at v�re aktivt medlem? [J/N]");
		if (sc.next().equalsIgnoreCase("N")){
			Medlem nytmedlem=new PassivMedlem(navn,bday,gender, harBetalt);
			medlemmer.add(nytmedlem);
			return medlemmer;
		}
		System.out.println("�nsker du at v�re konkurrencesv�mmer? [J/N]");
		if (sc.next().equalsIgnoreCase("n")) {
			Medlem nytmedlem = new Medlem(navn, bday, gender, harBetalt);
			medlemmer.add(nytmedlem);
			return medlemmer;
		}
		String aktivdisciplin="";
		System.out.println("tast de discipliner du vil stille op i, uden komma i mellem: ");
		System.out.println("brystsv�mnin=b, crawl=c, ryg=r, butterfly=f");
		aktivdisciplin=aktivdisciplin.concat(sc.next());

		Medlem nytmedlem=new Konkurrencesv�mmer(navn, bday, gender, harBetalt, aktivdisciplin);
		medlemmer.add(nytmedlem);
		return medlemmer;



		// tilf�j nyt medlem til ArrayList


	}
}