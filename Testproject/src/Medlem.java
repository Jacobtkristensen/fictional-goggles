import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;


public class Medlem implements Kontingent {
	private static int medlemmer=1;
	private int medlemsnummer;
	private String navn;
	private LocalDate fødseldag;
	private boolean gender;

	private double kontingent = 0;
	private boolean aktiv;

	public Medlem(String navn, LocalDate fødseldag, boolean gender){
		medlemsnummer=medlemmer;
		medlemmer++;
		this.navn=navn;
		this.fødseldag=fødseldag;
		this.gender=gender;
	}

	/**
	 * 
	 * @param f�dselsdag
	 */
	public int getAlder(LocalDate fødselsdag) {
		// TODO - implement Medlem.getAlder

		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(fødselsdag.getYear(),fødselsdag.getMonth(),fødselsdag.getDayOfMonth());
		Period period = Period.between(birthday, today);
		return period.getYears();
	}


	@Override
	public double beregnKontingent() {
		double passiv = 500;
		double rabat = 0.75;
		double kontingent = 1600;
		double kontingentung = 1000;
		if (getAlder() > 60) {
			return rabat * kontingent;
		}
		else if (getAlder() < 18) {
			return kontingentung;
		}
		else if (this.aktiv == false) {
			return passiv;

		}
		else {
			return kontingent;
		}
	}
}