package main;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import helpers.SortByName;

public class FuncionariosLista {
    List<Funcionario> employees;

    public FuncionariosLista() {
      this.employees = new ArrayList<>();
    }

    public void insert(Funcionario funcionario) {
        this.employees.add(funcionario);
    }

    public void printEmployees() {
        this.employees
              .forEach(func -> System.out.println(func.toString()));
    }

    public void updateAllSalary(String value) {
        BigDecimal multiplicand = new BigDecimal(value);
        this.employees
              .forEach(func -> func.setSalary(func.getSalary()
                                                    .multiply(multiplicand)));
    }

    public void printByRole() {
        Map<String, List<Funcionario>> funcByRole = this.employees.stream()
            .collect(
                Collectors.groupingBy(Funcionario::getRole));
        System.out.println(funcByRole.toString());
    }

    public void printByMonthBirthday(int month) {
        Predicate<Funcionario> byMonth = 
            func -> func.getBirthday().getMonthValue() == month;

        List<Funcionario> funcs = this.employees.stream()
            .filter(byMonth)
                .collect(Collectors.toList());
        
        System.out.println(funcs);
    }

    public void printByMonthBirthday(List<Integer> months) {
        List<Integer> monthsList = new ArrayList<>(months);

        Predicate<Funcionario> byMonth = 
            func -> monthsList.contains(func.getBirthday().getMonthValue());

        List<Funcionario> funcs = this.employees.stream()
            .filter(byMonth)
                .collect(Collectors.toList());
        
        System.out.println(funcs);
    }

    public void printSorted() {
        List<Funcionario> sortedEmployees = this.employees;
        sortedEmployees.sort(new SortByName());
        System.out.println(sortedEmployees);
    }

    public void printOldestEmployee() {
        Funcionario oldest = this.employees.get(0);
        for (Funcionario employee : this.employees) {
            if (employee.isOlderThan(oldest)) {
              oldest = employee;
            }
        }
        System.out.println(String.format("{%s, %s}",
                              oldest.getName(), oldest.formatedBirthday()));
    }
}
