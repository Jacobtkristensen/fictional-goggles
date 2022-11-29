import java.time.LocalDateTime;
import java.util.Date;

public abstract class Medlem implements Kontingent {
	private static int medlemmer
	private int medlemsnummer;
	private String navn;
	private LocalDateTime fødseldag;
	private boolean gender;



	/**
	 * 
	 * @param f�dselsdag
	 */
	public int getAlder(LocalDateTime fødselsdag) {
		// TODO - implement Medlem.getAlder
		throw new UnsupportedOperationException();
	}

}