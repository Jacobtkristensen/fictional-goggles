import java.io.Serializable;
import java.time.LocalTime;
import java.util.Scanner;

public class Sv�mmedisciplin implements Serializable {
	private String disciplinNavn;
	private Resultat resultater;
	private LocalTime currentbest;

	//constructors...noarg constructor must be found
	public Sv�mmedisciplin(){
		this.disciplinNavn="NyDisciplin";
		this.resultater=new Resultat();
		this.currentbest=this.resultater.getResult();
	}
	public Sv�mmedisciplin(String disciplinNavn){
		this.disciplinNavn=disciplinNavn;
		this.resultater=new Resultat();
		this.currentbest=this.resultater.getResult();
	}
	public Sv�mmedisciplin(String disciplinnavn, LocalTime resultat){
		this.disciplinNavn=disciplinNavn;
		this.resultater= new Resultat();
		this.currentbest=resultat;
		this.resultater.setBedsteTid(resultat);
	}
	public String getDisciplinNavn() {
		return disciplinNavn;
	}

	public Resultat getResultater() {
		return resultater;
	}
	public String toString(){
		return " "+ this.getDisciplinNavn()+" "+getResultater().getResult()+" ";
	}


}