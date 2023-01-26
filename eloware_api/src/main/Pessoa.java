package main;
import java.time.LocalDate;

public class Pessoa {
    String name;
    LocalDate birthday;

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
}
