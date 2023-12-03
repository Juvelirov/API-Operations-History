package ru.netology.adenisov.domain;

import lombok.Data;
import ru.netology.adenisov.domain.ConsolePrintable;

@Data
public class Client implements ConsolePrintable {
    private int id;
    private String name;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void printToConsole() {
        System.out.println(id + name);
    }
}
