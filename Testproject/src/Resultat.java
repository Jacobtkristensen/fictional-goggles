import java.time.LocalDate;
import java.time.LocalTime;

public class Resultat {

	private LocalDate tr�ningsdato=LocalDate.now();
	private LocalTime tr�ningstid= LocalTime.now();
	private String st�vnenavn="ikke deltaget i st�vne endnu";
	private int placering=-99;
	private LocalTime st�vnetid=LocalTime.now();

	private LocalTime bedsteTid=LocalTime.now();

	public Resultat(){}

	public Resultat(String tr�ningsdato, String tr�ningstid){
		this.tr�ningsdato=LocalDate.parse(tr�ningsdato);
		this.tr�ningstid=LocalTime.parse(tr�ningstid);
		if(this.tr�ningstid<this.st�vnetid){
			this.bedsteTid=this.tr�ningstid;
		}
		else{
			bedsteTid=st�vnetid;
		}
	}
	public void setSt�vneresultater(String st�vnenavn, int placering, String st�vnetid){
		this.st�vnenavn=st�vnenavn;
		this.placering=placering;
		this.st�vnetid=LocalTime.parse(st�vnetid);
		if(this.tr�ningstid<this.st�vnetid){
			this.bedsteTid=this.tr�ningstid;
		}
		else{
			this.bedsteTid=this.st�vnetid;
		}
	}
	public void setTr�ningsresultater(String tr�ningsdato, String tr�ningstid){
		this.tr�ningsdato=LocalDate.parse(tr�ningsdato);
		this.tr�ningstid=LocalTime.parse(tr�ningstid);
		if(this.tr�ningstid<this.st�vnetid){
			this.bedsteTid=this.tr�ningstid;
		}
		else{
			this.bedsteTid=this.st�vnetid;
		}
	}
	public LocalTime getResult(){
		return bedsteTid;
	}
}