import java.io.Serializable;
import java.time.LocalTime;
import java.util.Scanner;

public class Svømmedisciplin implements Serializable {
	private String disciplinNavn;
	private Resultat resultater;
	private LocalTime currentbest;

	//constructors...noarg constructor must be found
	public Svømmedisciplin(){
		this.disciplinNavn="NyDisciplin";
		this.resultater=new Resultat();
		this.currentbest=this.resultater.getResult();
	}
	public Svømmedisciplin(String disciplinNavn){
		this.disciplinNavn=disciplinNavn;
		this.resultater=new Resultat();
		this.currentbest=this.resultater.getResult();
	}
	public Svømmedisciplin(String disciplinnavn, LocalTime resultat){
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