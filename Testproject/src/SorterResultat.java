import java.util.Comparator;

public class SorterResultat implements Comparator<Konkurrencesv�mmer> {

    public void setIndex(int index) {
        this.index = index;
    }

    private int index=-99;
    public SorterResultat(int i){
        this.index= i;
    }
    //getter
    public int getIndex(){
        return index;
    }
    public int compare(Konkurrencesv�mmer a, Konkurrencesv�mmer b){

      return  a.getResults()[getIndex()].compareTo(b.getResults()[getIndex()]);
    }

}