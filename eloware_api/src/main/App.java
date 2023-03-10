package main;
import java.util.List;

import helpers.Log;

import java.math.BigDecimal;

public class App {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        FuncionariosLista funcLista = new FuncionariosLista();
        
        // Insere os funcionários da tabela
        funcLista.insert(new Funcionario("Maria", "2000-10-18", "2009.44", "Operador"));
        funcLista.insert(new Funcionario("João", "1990-05-12", "2284.38", "Operador"));
        funcLista.insert(new Funcionario("Caio", "1961-05-02", "9836.14", "Coordenador"));
        funcLista.insert(new Funcionario("Miguel", "1988-10-14", "19119.88", "Diretor"));
        funcLista.insert(new Funcionario("Alice", "1995-01-05", "2234.68", "Recepcionista"));
        funcLista.insert(new Funcionario("Heitor", "1999-11-19", "1582.72", "Operador"));
        funcLista.insert(new Funcionario("Arthur", "1993-03-31", "4071.84", "Contador"));
        funcLista.insert(new Funcionario("Laura", "1994-07-08", "3017.45", "Gerente"));
        funcLista.insert(new Funcionario("Heloísa", "2003-05-24", "1606.85", "Eletricista"));
        funcLista.insert(new Funcionario("Helena", "1996-09-02", "2799.93", "Gerente"));


        // Remove um funcionario da lista com base no nome informado
        funcLista.delete("João");


        // Imprime todos os funcionários na lista
        Log.print("Todos os funcionários:\n" + funcLista.listAllEmployees() + "\n");


        // Atualiza salários dos funcionários em 110%
        funcLista.updateAllSalary("1.10");


        // Agrupa por função e imprime o mapeamento
        Log.print("Funcionários por função:\n" + funcLista.listByRole() + "\n");


        // Imprime funcionários com aniversários no mês 10 ou 12
        List<Integer> months = List.of(10, 12);
        Log.print("Aniversariantes dos meses selecionados:\n" +
                      funcLista.listByMonthBirthday(months) +  "\n");


        // Imprime o funcionário com maior idade
        Log.print("O funcionário com maior idade é: " +
                      funcLista.getOldestEmployee() + "\n");


        // Imprime a lista de funcionários em ordem alfabética
        Log.print("Lista de funcionários (ordem alfabética):\n" +
                      funcLista.listSortedByName() + "\n");


        // Imprime a soma de todas os salários
        Log.print("Soma de todos os salários: " +
                      funcLista.getSalarySummation() + "\n");


        // Imprime quantos salários mínimos ganha cada funcionário
        BigDecimal currentMinWage = new BigDecimal("1212.00");
        Log.print(funcLista.listMinimunWagesByEmployee(currentMinWage).toString());
    }
}
