import java.time.LocalTime;
import java.util.Comparator;

public class SorterResultat implements Comparator<Resultat> {
    public int compare(Konkurrencesv�mmer a, Konkurrencesv�mmer b){
      return  a.getResults().getResult().compareTo(b.getResults().getResult());
    }
}