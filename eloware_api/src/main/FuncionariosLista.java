package main;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import helpers.SortByName;

public class FuncionariosLista {
    private List<Funcionario> employees;

    public FuncionariosLista() {
      this.employees = new ArrayList<>();
    }

    
    /** 
     * @param employee
     */
    public void insert(Funcionario employee) {
        this.employees.add(employee);
    }

    
    /** 
     * @return List<String>
     */
    public List<String> listAllEmployees() {
        return this.employees.stream()
                  .map(Funcionario::toString)
                  .collect(Collectors.toList());
    }

    
    /** 
     * @param value
     */
    public void updateAllSalary(String value) {
        BigDecimal multiplicand = new BigDecimal(value);
        this.employees
              .forEach(func -> func.setSalary(func.getSalary()
                                                  .multiply(multiplicand)));
    }

    
    /** 
     * @return String
     */
    public String listByRole() {
        return this.employees.stream()
                  .collect(Collectors
                  .groupingBy(Funcionario::getRole))
                  .toString();
    }

    
    /** 
     * @param month
     * @return List of Funcionario
     */
    public List<Funcionario> listByMonthBirthday(int month) {
        Predicate<Funcionario> byMonth = 
            func -> func.getBirthday().getMonthValue() == month;

        return this.employees.stream()
                  .filter(byMonth)
                  .collect(Collectors.toList());
    }

    
    /** 
     * @param months a List of Integers
     * @return List of Funcionario
     */
    public List<Funcionario> listByMonthBirthday(List<Integer> months) {
        List<Integer> monthsList = new ArrayList<>(months);

        Predicate<Funcionario> byMonth = 
            func -> monthsList.contains(func.getBirthday().getMonthValue());

          return this.employees.stream()
                    .filter(byMonth)
                    .collect(Collectors.toList());
    }


    /**
     * @return List of Funcionario
     */
    public List<Funcionario> listSortedByName() {
        ArrayList<Funcionario> sortedEmployees = new ArrayList<>();
        sortedEmployees.addAll(this.employees);
        sortedEmployees.sort(new SortByName());
        return sortedEmployees;
    }


    /**
     * @return String
     */
    public String getOldestEmployee() {
        Funcionario oldest = this.employees.get(0);
        for (Funcionario employee : this.employees) {
            if (employee.isOlderThan(oldest)) {
              oldest = employee;
            }
        }
         return String.format("{%s, %s}", oldest.getName(),
                                  oldest.formatedBirthday());
    }


    /**
     * @return String
     */
    public String getSalarySummation() {
        BigDecimal summation = this.employees.stream()
            .reduce(new BigDecimal("0.0"), (a, b) -> a.add(b.getSalary()), BigDecimal::add);
        return Funcionario.formatSalary((summation));
    }

    
    /** 
     * @param minWage a BigDecimal
     * @return StringBuilder
     */
    public StringBuilder listMinimunWagesByEmployee(BigDecimal minWage) {
        StringBuilder minWagesByEmployee = new StringBuilder();
        for (Funcionario employee : this.employees) {
              int result = employee.countMinimumWages(minWage);
              String howMany = result <= 1 ? "salário mínimo" : "salários mínimos";
              minWagesByEmployee.append(String.format("%s recebe cerca de %s %s.\n", 
                                                      employee.getName(), result, howMany));
        }
        return minWagesByEmployee;
    }
}
