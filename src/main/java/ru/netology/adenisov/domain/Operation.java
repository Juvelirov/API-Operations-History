package ru.netology.adenisov.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Operation {
    private int id;
    private int sum;
    private String currency;
    private String merchant;

    public Operation(int sum, String currency, String merchant, int id) {
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
        this.id = id;
    }

    public void printToConsole() {
        System.out.println("Сумма " + sum + ", Место: " + merchant);
    }

    @Override
    public String toString() {
        return "Operation{" + "id: " + id +
                ", sum: " + sum +
                ", currency: " + currency +
                ", merchant: " + merchant +
                "}";
    }
}
