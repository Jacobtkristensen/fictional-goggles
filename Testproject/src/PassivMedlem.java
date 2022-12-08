import java.io.Serializable;
import java.time.LocalDate;

public class PassivMedlem extends Medlem implements Serializable {
    public PassivMedlem(String navn, LocalDate fødseldag, boolean gender, boolean harBetalt){
        super(navn, fødseldag, gender, harBetalt);
    }
    public PassivMedlem(){
        super();
    }

    public PassivMedlem(int medlemnr, String medlemnavn, LocalDate bday, boolean isMale, String memberType, double fee, boolean hasPaid) {
   super(medlemnr,medlemnavn,bday,isMale,memberType,fee,hasPaid);
    }


    @Override
    public double beregnKontingent() {
        return 500;
    }
}