package helpers;

import java.util.Comparator;

import main.Funcionario;

public class SortByName implements Comparator<Funcionario>{
    
    
    /** 
     * @param func1
     * @param func2
     * @return int
     */
    public int compare(Funcionario func1, Funcionario func2) {
        return func1.getName().compareTo(func2.getName());
    }
}
