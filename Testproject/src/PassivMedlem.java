import java.time.LocalDate;

public class PassivMedlem extends Medlem {
    public PassivMedlem(String navn, LocalDate f�dseldag, boolean gender){
        super(navn, f�dseldag, gender);
    }


    @Override
    public double beregnKontingent() {
        return 500;
    }
}