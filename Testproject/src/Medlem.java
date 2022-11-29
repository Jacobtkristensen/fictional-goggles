import java.util.Date;

public abstract class Medlem implements Kontingent {

	private int medlemsnummer;
	private String navn;
	private Date fødseldag;
	private boolean gender;

	/**
	 * 
	 * @param f�dselsdag
	 */
	public int getAlder(Date fødselsdag) {
		// TODO - implement Medlem.getAlder
		throw new UnsupportedOperationException();
	}

}