import java.time.LocalTime;

public class St�vneResultat {

	private String st�vneNavn="endnu ikke deltaget i et st�vne";
	private int placering=-99;
	private LocalTime tid;

	public St�vneResultat(String st�vneNavn, int placering, LocalTime tid){
		this.st�vneNavn=st�vneNavn;
		this.placering=placering;
		this.tid=tid;
	}
	public LocalTime getTid(){
		return tid;
	}

}