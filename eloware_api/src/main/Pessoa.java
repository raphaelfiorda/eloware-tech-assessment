package main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String name;
    private LocalDate birthday;


    /**
     * @see Class#Constructor(String, CharSequence)
     */
    public Pessoa (String name, CharSequence birthday) {
        this.name = name;
        this.birthday = LocalDate.parse(birthday);
    }

    
    /** 
     * @return String
     */
    public String getName () {
        return this.name;
    }

    
    /** 
     * @return LocalDate
     */
    public LocalDate getBirthday () {
        return this.birthday;
    }

    
    /** 
     * @return String
     */
    public String formatedBirthday() {
        String standardFormat = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(standardFormat);
        return getBirthday().format(formatter);
    }

    
    /** 
     * @param person  instance of Pessoa
     * @return boolean
     */
    public boolean isOlderThan (Pessoa person) {
        return this.birthday.isBefore(person.getBirthday());
    }
}
