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
}
