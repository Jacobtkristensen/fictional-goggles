import java.time.LocalDate;
import java.time.LocalTime;

public class Tr�ningsresultat {

	private LocalDate tr�ningsdato;
	private LocalTime tr�ningstid;
public Tr�ningsresultat(String tr�ningsdato, String tid){
	this.tr�ningsdato=LocalDate.parse(tr�ningsdato);
	this.tr�ningstid=LocalTime.parse(tid);
}

	public LocalTime getTr�ningstid() {
		return tr�ningstid;
	}
}