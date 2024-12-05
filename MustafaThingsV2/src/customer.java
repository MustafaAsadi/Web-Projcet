import java.time.LocalDate;

public class customer {
    public final String customerName;
    public final String number;
    public final String Emali;
    public final LocalDate DOB;

    public customer(String customerName, String number, String emali, LocalDate dob) {
        this.customerName = customerName;
        this.number = number;
        Emali = emali;
        DOB = dob;
    }

    @Override
    public String toString() {
        return "customer{" +
                "customerNumber='" + customerName + '\'' +
                ", number=" + number +
                '}';
    }
}
