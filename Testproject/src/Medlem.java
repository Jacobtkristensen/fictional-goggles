import java.util.Date;

public abstract class Medlem implements Kontingent {
	private static int medlemmer=1;
	private int medlemsnummer;
	private String navn;
	private Date fødseldag;
	private boolean gender;

	public Medlem(String navn, Date fødseldag, boolean gender){
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
	public int getAlder(Date fødselsdag) {
		// TODO - implement Medlem.getAlder
		throw new UnsupportedOperationException();
	}

}