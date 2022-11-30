import java.time.LocalDate;
import java.time.LocalTime;

public class Træningsresultat {

	private LocalDate træningsdato;
	private LocalTime træningstid;
public Træningsresultat(String træningsdato, String tid){
	this.træningsdato=LocalDate.parse(træningsdato);
	this.træningstid=LocalTime.parse(tid);
}

	public LocalTime getTræningstid() {
		return træningstid;
	}
}