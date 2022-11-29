import java.time.LocalTime;

public class StævneResultat {

	private String stævneNavn="endnu ikke deltaget i et stævne";
	private int placering=-99;
	private LocalTime tid;

	public StævneResultat(String stævneNavn, int placering, LocalTime tid){
		this.stævneNavn=stævneNavn;
		this.placering=placering;
		this.tid=tid;
	}
	public LocalTime getTid(){
		return tid;
	}

}