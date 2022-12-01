import java.time.LocalDate;
import java.time.LocalTime;

public class Resultat {

	private LocalDate træningsdato=LocalDate.now();
	private LocalTime træningstid= LocalTime.now();
	private String stævnenavn="ikke deltaget i stævne endnu";
	private int placering=-99;
	private LocalTime stævnetid=LocalTime.now();

	private LocalTime bedsteTid=LocalTime.now();

	public Resultat(){}

	public Resultat(String træningsdato, String træningstid){
		this.træningsdato=LocalDate.parse(træningsdato);
		this.træningstid=LocalTime.parse(træningstid);
		if(this.træningstid<this.stævnetid){
			this.bedsteTid=this.træningstid;
		}
		else{
			bedsteTid=stævnetid;
		}
	}
	public void setStævneresultater(String stævnenavn, int placering, String stævnetid){
		this.stævnenavn=stævnenavn;
		this.placering=placering;
		this.stævnetid=LocalTime.parse(stævnetid);
		if(this.træningstid<this.stævnetid){
			this.bedsteTid=this.træningstid;
		}
		else{
			this.bedsteTid=this.stævnetid;
		}
	}
	public void setTræningsresultater(String træningsdato, String træningstid){
		this.træningsdato=LocalDate.parse(træningsdato);
		this.træningstid=LocalTime.parse(træningstid);
		if(this.træningstid<this.stævnetid){
			this.bedsteTid=this.træningstid;
		}
		else{
			this.bedsteTid=this.stævnetid;
		}
	}
	public LocalTime getResult(){
		return bedsteTid;
	}
}