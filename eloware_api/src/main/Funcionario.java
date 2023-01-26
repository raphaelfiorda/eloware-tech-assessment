package main;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
    
    /** 
     * @return String
     */
    public static String formatSalary(BigDecimal salary) {
        return new DecimalFormat("#,###.##", 
                                  new DecimalFormatSymbols(Locale.ITALIAN)).format(salary);
    }

    
    /** 
     * @return BigDecimal
     */
    public BigDecimal getSalary() {
        return this.salary;
    }

    
    /** 
     * @return String
     */
    public String getRole() {
        return this.role;
    }

    
    /** 
     * @param newSalary
     */
    public void setSalary (BigDecimal newSalary) {
        this.salary = newSalary;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString () {
        String standardFormat = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(standardFormat);
        return String.format("{%s, %s, %s, %s}", name,
                                  birthday.format(formatter), Funcionario.formatSalary(salary), role);
      }
}
