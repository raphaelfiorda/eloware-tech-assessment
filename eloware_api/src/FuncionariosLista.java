import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;

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
              .forEach((func) -> System.out.println(func.toString()));
    }

    public void updateAllSalary(String value) {
        BigDecimal multiplicand = new BigDecimal(value);
        this.funcionarios
              .forEach((func) -> func.setSalary(func.getSalary()
                                                    .multiply(multiplicand)));
    }

    public void printByRole() {
        Map<String, List<Funcionario>> funcByRole = funcionarios.stream()
            .collect(
                Collectors.groupingBy(Funcionario::getRole));
        System.out.println(funcByRole.toString());
    }
}
