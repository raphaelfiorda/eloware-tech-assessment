import java.math.BigDecimal;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        String name = "João";
        CharSequence birthday = "2000-10-18";
        String role = "Operador";
        String salary = "2009.44";

        Funcionario funcionario = new Funcionario(name, birthday, salary, role);
        Funcionario funcionario2 = new Funcionario("Maria", "1990-05-12", "2284.38", "Operador");

        System.out.println(funcionario.getString());
        System.out.println(funcionario2.getString());
    }
}
