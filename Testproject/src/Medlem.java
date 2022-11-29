import java.time.LocalDate;
import java.time.Period;


public class Medlem {
	private static int medlemmer=1;
	private int medlemsnummer;
	private String navn;
	private LocalDate foedselsdag;
	private boolean gender;

	private double kontingent = 0;

	public Medlem(String navn, LocalDate foedselsdag, boolean gender){
		medlemsnummer=medlemmer;
		medlemmer++;
		this.navn=navn;
		this.foedselsdag = foedselsdag;
		this.gender=gender;
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
}