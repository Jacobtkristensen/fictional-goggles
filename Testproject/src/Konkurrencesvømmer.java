import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Konkurrencesv�mmer extends Medlem implements Serializable {
	private boolean[] aktivdisciplin=new boolean[4];

	private Sv�mmedisciplin[] discipliner=new Sv�mmedisciplin[4];
	private LocalTime[] resultater=new LocalTime[4];
	transient DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
	//constructors. in order to be able to serialize/deserialize a no-argument constructor must be available
	public Konkurrencesv�mmer(){
		super();
		for(int i=0;i<4;i++){
			this.aktivdisciplin[i]=false;
			this.discipliner[i]=new Sv�mmedisciplin();
			this.resultater[i]=LocalTime.parse("23:59:59.000",tidsformat);
		}

	}
	// til at nyoprette et medlem
	public Konkurrencesv�mmer(String navn, LocalDate bday, boolean gender, boolean harBetalt, String disciplinset){ //til at oprette nye medlemmer
		super(navn,bday,gender, harBetalt);
		this.aktivdisciplin=setAktivDiscipliner(disciplinset);
		 DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		String tider="23:59:59.000";
		LocalTime initialtider=LocalTime.parse(tider,tidsformat);
		for (int i=0;i<4;i++){
			if(aktivdisciplin[i]){
				if(i==0){    //"brystsv�mning=b, crawl=c, ryg=r, butterfly=f"
					discipliner[i]=new Sv�mmedisciplin("brystsv�mning");
				}
				if(i==1){
					discipliner[i]=new Sv�mmedisciplin("crawl");
				}
				if(i==2){
					discipliner[i]=new Sv�mmedisciplin("ryg");
				}
				if(i==3){
					discipliner[i]=new Sv�mmedisciplin("butterfly");
				}
			}
			resultater[i]=initialtider;
		}


		 //tider="23:59:59.002";
		// initialtider=LocalTime.parse(tider,tidsformat);
		//Arrays.fill(resultater,initialtider);
	}
	// til at oprette et medlem fra fil
	public Konkurrencesv�mmer(int medlemsnummer, String navn, LocalDate foedselsdag, boolean gender, String type, double kontingent, boolean harBetalt,boolean[] aktivdisciplins, LocalTime[] bedsteresultater){ // til at indl�se medlemmer fra fil
		super(medlemsnummer, navn,foedselsdag,gender,type, kontingent, harBetalt);
		this.aktivdisciplin=setAktivDiscipliner(aktivdisciplins);
		DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		String tider="23:59:59.999";
		LocalTime initialtider=LocalTime.parse(tider,tidsformat);
		for (int i=0;i<4;i++){
			if(this.aktivdisciplin[i]){
				if(i==0){    //"brystsv�mning=b, crawl=c, ryg=r, butterfly=f"
					this.discipliner[i]=new Sv�mmedisciplin("brystsv�mning");
					this.discipliner[i].getResultater().setBedsteTid(bedsteresultater[i]);
					this.resultater[i]=bedsteresultater[i];
				}
				if(i==1){
					this.discipliner[i]=new Sv�mmedisciplin("crawl");
					this.discipliner[i].getResultater().setBedsteTid(bedsteresultater[i]);
					this.resultater[i]=bedsteresultater[i];
				}
				if(i==2){
					this.discipliner[i]=new Sv�mmedisciplin("ryg");
					this.discipliner[i].getResultater().setBedsteTid(bedsteresultater[i]);
					this.resultater[i]=bedsteresultater[i];
				}
				if(i==3){
					this.discipliner[i]=new Sv�mmedisciplin("butterfly");
					this.discipliner[i].getResultater().setBedsteTid(bedsteresultater[i]);
					this.resultater[i]=bedsteresultater[i];
				}
			}
			else {
				this.resultater[i]=initialtider;
			}


		}

	}

	public String printTilKonsol(){
		String s=Arrays.toString(discipliner);
		return super.printTilKonsol()+s;
	}

	public String toString(){
		String a="",d="",r="";
		for(int i=0;i<4;i++){
			a=a.concat(aktivdisciplin[i]+" ");
			d=d.concat(discipliner[i]+" ");
			r=r.concat(resultater[i]+" ");
		}
		String s=super.toString()+" "+a+" "+d+" "+r;
		return s;
	}
	public boolean[] setAktivDiscipliner(String disciplinset) { //til
		if(disciplinset.contains("b")){
			aktivdisciplin[0]=true;
		}
		if(disciplinset.contains("c")){
			aktivdisciplin[1]=true;
		}
		if(disciplinset.contains("r")){
			aktivdisciplin[2]=true;
		}
		if(disciplinset.contains("f")){
			aktivdisciplin[3]=true;
		}
		return aktivdisciplin;
	}

	public boolean[] setAktivDiscipliner(boolean[] aktivdisciplins) {
		for (int i=0;i<4;i++) {
			if( aktivdisciplins[i]){
				aktivdisciplin[i]=true;
			}
			else{
				aktivdisciplin[i]=false;
			}
		}
		return aktivdisciplin;
	}

	public boolean[] getAktivdisciplin() {
		return aktivdisciplin;
	}
	public LocalTime[] getResults() {

		for (int i=0;i<4;i++){
			if(aktivdisciplin[i]){
				resultater[i]= discipliner[i].getResultater().getResult();
			}
			else{
				resultater[i]=LocalTime.parse("23:59:59.999",tidsformat);
			}
		}
		return resultater;
	}


	public void tilf�jDisciplin() {
		Scanner sc=new Scanner(System.in);
		System.out.println("sv�mmeren er aktiv i f�lgende discipliner");
		for(int i=0;i<aktivdisciplin.length;i++){
			if(aktivdisciplin[i]){
				System.out.println(getDiscipliner()[i].getDisciplinNavn());
			}
		}
		System.out.println("hvilke discpliner vil tilf�je/�ndre?: ");
		System.out.println("1: brystsv�mning");
		System.out.println("2: crawl");
		System.out.println("3: rygsv�mning");
		System.out.println("4: Butterfly");
		int valg;
		valg=sc.nextInt();
		switch (valg){
			case 1:
				System.out.println();
				break;
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 4:
				System.out.println();
				break;
		}
	}
	public Sv�mmedisciplin[] getDiscipliner() {
		return discipliner;
	}
}