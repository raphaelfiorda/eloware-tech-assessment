import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salary;
    public String role;

    public Funcionario (String name, CharSequence birthday,
                        String salary, String role ) {
        super(name, birthday);
        this.salary = new BigDecimal(salary);
        this.role = role;
    }
    public String formatSalary() {
        String formatedSalary = new DecimalFormat("#,###.##", 
                                  new DecimalFormatSymbols(Locale.ITALIAN)).format(this.salary);
        return formatedSalary;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public String getRole() {
        return this.role;
    }

    public void setSalary (BigDecimal newSalary) {
        this.salary = newSalary;
    }

    @Override
    public String toString () {
        String standardFormat = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(standardFormat);
        String employeeStrData = String.format("{%s, %s, %s, %s}", name,
                                              birthday.format(formatter), formatSalary(), role);
        return employeeStrData;
      }
}
