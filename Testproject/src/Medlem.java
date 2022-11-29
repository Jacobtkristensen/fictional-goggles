import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;


public class Medlem implements Kontingent {
	private static int medlemmer=1;
	private int medlemsnummer;
	private String navn;
	private LocalDate fødseldag;
	private boolean gender;

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


}