import java.time.LocalTime;
import java.util.Comparator;

public class SorterResultat implements Comparator<Resultat> {
    public int compare(Konkurrencesvømmer a, Konkurrencesvømmer b){
      return  a.getResults().getResult().compareTo(b.getResults().getResult());
    }
}