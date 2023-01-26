package main;
import java.util.List;

public class App {
    public static void main(String[] args) {
        FuncionariosLista funcLista = new FuncionariosLista();

        // Insere os funcionários da tabela e imprime a lista
        funcLista.insert(new Funcionario("João", "2000-10-18", "2009.44", "Operador"));
        funcLista.insert(new Funcionario("Maria", "1990-05-12", "2284.38", "Operador"));
        funcLista.insert(new Funcionario("Caio", "1961-05-02", "9836.14", "Coordenador"));
        funcLista.insert(new Funcionario("Miguel", "1988-10-14", "19119.88", "Diretor"));
        funcLista.insert(new Funcionario("Alice", "1995-01-05", "2234.68", "Recepcionista"));
        funcLista.insert(new Funcionario("Heitor", "1999-11-19", "1582.72", "Operador"));
        funcLista.insert(new Funcionario("Arthur", "1993-03-31", "4071.84", "Contador"));
        funcLista.insert(new Funcionario("Laura", "1994-07-08", "3017.45", "Gerente"));
        funcLista.insert(new Funcionario("Heloísa", "2003-05-24", "1606.85", "Eletricista"));
        funcLista.insert(new Funcionario("Helena", "1996-09-02", "2799.93", "Gerente"));

        funcLista.printEmployees();

        // Atualiza salários dos funcionários em 110%
        funcLista.updateAllSalary("1.10");

        // Agrupa por função e imprime o mapeamento
        funcLista.printByRole();

        // Imprime funcionários com aniversários no mês 10 ou 12
        List<Integer> months = List.of(10, 12);
        funcLista.printByMonthBirthday(months);

        // Imprime o funcionário com maior idade
        funcLista.printOldestEmployee();

        // Imprime a lista de funcionários em ordem alfabética
        funcLista.printSorted();

        // Imprime a soma de todas os salários
        funcLista.printSummationSalary();

        // Imprime quantos salários mínimos ganha cada funcionário
    }
}
