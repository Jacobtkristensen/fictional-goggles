import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Resultat implements Serializable {

	private LocalDate tr�ningsdato=LocalDate.now();
	private LocalTime tr�ningstid;
	private String st�vnenavn="ikke deltaget i st�vne endnu";
	private int placering=-99;
	private LocalTime st�vnetid;

	private LocalTime bedsteTid;
	transient DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	public Resultat(){

		String tider="23:59:59.999";
		LocalTime initialtider=LocalTime.parse(tider,tidsformat);
		this.tr�ningstid=initialtider;
		this.st�vnetid=initialtider;
		this.bedsteTid=initialtider;
	}

	public Resultat(String tr�ningsdato, String tr�ningstid){
		this.tr�ningsdato=LocalDate.parse(tr�ningsdato);
		this.tr�ningstid=LocalTime.parse(tr�ningstid);
		if(this.tr�ningstid.compareTo(this.st�vnetid)<0){
			this.bedsteTid=this.tr�ningstid;
		}
		else{
			this.bedsteTid=this.st�vnetid;
		}
	}
	public void setSt�vneresultater(String st�vnenavn, int placering, String st�vnetid){
		this.st�vnenavn=st�vnenavn;
		this.placering=placering;
		this.st�vnetid=LocalTime.parse(st�vnetid);
		if(this.tr�ningstid.compareTo(this.st�vnetid)<0){
			this.bedsteTid=this.tr�ningstid;
		}
		else{
			this.bedsteTid=this.st�vnetid;
		}
	}
	public void setTr�ningsresultater(String tr�ningsdato, String tr�ningstid){
		this.tr�ningsdato=LocalDate.parse(tr�ningsdato);
		this.tr�ningstid=LocalTime.parse(tr�ningstid);
		if(this.tr�ningstid.compareTo(this.st�vnetid)<0){
			this.bedsteTid=this.tr�ningstid;
		}
		else{
			this.bedsteTid=this.st�vnetid;
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