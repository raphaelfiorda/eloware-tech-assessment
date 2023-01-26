import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosLista {
    List<Funcionario> funcionarios;

    public FuncionariosLista() {
      this.funcionarios = new ArrayList<Funcionario>();
    }

    public void insert(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void printEmployees() {
        this.funcionarios
              .forEach((func) -> System.out.println(func.getString()));
    }

    public void updateAllSalary(String value) {
        BigDecimal multiplicand = new BigDecimal(value);
        this.funcionarios
              .forEach((func) -> func.setSalary(func.getSalary()
                                                    .multiply(multiplicand)));
    }
}
