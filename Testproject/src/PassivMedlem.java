import java.io.Serializable;
import java.time.LocalDate;

public class PassivMedlem extends Medlem implements Serializable {
    public PassivMedlem(String navn, LocalDate fødseldag, boolean gender, boolean harBetalt){
        super(navn, fødseldag, gender, harBetalt);
    }
    public PassivMedlem(){
        super();
    }


    @Override
    public double beregnKontingent() {
        return 500;
    }
}