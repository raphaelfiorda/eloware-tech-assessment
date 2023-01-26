package main;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salary;
    private String role;

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

    public int countMinimumWages(BigDecimal minWage) {
        return getSalary()
                  .divideToIntegralValue(minWage)
                  .intValue();
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString () {
        return String.format("{%s, %s, %s, %s}", getName(),
                                  formatedBirthday(), Funcionario.formatSalary(salary), this.role);
    }
}
