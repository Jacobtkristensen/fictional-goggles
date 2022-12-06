import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Resultat implements Serializable {

	private LocalDate træningsdato=LocalDate.now();
	private LocalTime træningstid;
	private String stævnenavn="ikke deltaget i stævne endnu";
	private int placering=-99;
	private LocalTime stævnetid;

	private LocalTime bedsteTid;
	transient DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	public Resultat(){

		String tider="23:59:59.999";
		LocalTime initialtider=LocalTime.parse(tider,tidsformat);
		this.træningstid=initialtider;
		this.stævnetid=initialtider;
		this.bedsteTid=initialtider;
	}

	public Resultat(String træningsdato, String træningstid){
		this.træningsdato=LocalDate.parse(træningsdato);
		this.træningstid=LocalTime.parse(træningstid);
		if(this.træningstid.compareTo(this.stævnetid)<0){
			this.bedsteTid=this.træningstid;
		}
		else{
			this.bedsteTid=this.stævnetid;
		}
	}
	public void setStævneresultater(String stævnenavn, int placering, String stævnetid){
		this.stævnenavn=stævnenavn;
		this.placering=placering;
		this.stævnetid=LocalTime.parse(stævnetid);
		if(this.træningstid.compareTo(this.stævnetid)<0){
			this.bedsteTid=this.træningstid;
		}
		else{
			this.bedsteTid=this.stævnetid;
		}
	}
	public void setTræningsresultater(String træningsdato, String træningstid){
		this.træningsdato=LocalDate.parse(træningsdato);
		this.træningstid=LocalTime.parse(træningstid);
		if(this.træningstid.compareTo(this.stævnetid)<0){
			this.bedsteTid=this.træningstid;
		}
		else{
			this.bedsteTid=this.stævnetid;
		}
	}
	public LocalTime getResult(){
		return bedsteTid;
	}
	public String toString(){
		return this.bedsteTid.format(tidsformat);

	}
	public void setBedsteTid(LocalTime res){
		this.bedsteTid=res;
	}
}