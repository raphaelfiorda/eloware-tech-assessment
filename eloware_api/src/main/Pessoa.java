package main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String name;
    private LocalDate birthday;

    public Pessoa (String name, CharSequence birthday) {
        this.name = name;
        this.birthday = LocalDate.parse(birthday);
    }

    public String getName () {
        return this.name;
    }

    public LocalDate getBirthday () {
        return this.birthday;
    }

    public String formatedBirthday() {
        String standardFormat = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(standardFormat);
        return getBirthday().format(formatter);
    }

    public boolean isOlderThan (Pessoa person) {
        return this.birthday.isBefore(person.getBirthday());
    }
}
