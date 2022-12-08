import java.io.Serializable;
import java.time.LocalDate;

public class PassivMedlem extends Medlem implements Serializable {
    public PassivMedlem(String navn, LocalDate f�dseldag, boolean gender, boolean harBetalt){
        super(navn, f�dseldag, gender, harBetalt);
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