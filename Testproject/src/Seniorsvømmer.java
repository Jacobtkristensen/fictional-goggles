public class Seniorsv�mmer extends Konkurrencesv�mmer {

	private Sv�mmedisciplin[] discipliner=Sv�mmedisciplin[4];
	private boolean[] aktivdisciplin=boolean[4];
	//Brystsv�mning, Crawl, Rygsv�mning, Butterfly


	public void setAktivDiscipliner(String disciplinset) {
		if(disciplinset.contains("b")){
			aktivdisciplin[0]=true;
		}
	}
}