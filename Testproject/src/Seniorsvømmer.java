public class Seniorsvømmer extends Konkurrencesvømmer {

	private Svømmedisciplin[] discipliner=Svømmedisciplin[4];
	private boolean[] aktivdisciplin=boolean[4];
	//Brystsvømning, Crawl, Rygsvømning, Butterfly


	public void setAktivDiscipliner(String disciplinset) {
		if(disciplinset.contains("b")){
			aktivdisciplin[0]=true;
		}
	}
}