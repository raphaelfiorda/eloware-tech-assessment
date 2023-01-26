package helpers;

import java.util.Comparator;

import main.Funcionario;

public class SortByName implements Comparator<Funcionario>{
    
    public int compare(Funcionario func1, Funcionario func2) {
        return func1.getName().compareTo(func2.getName());
    }
}
