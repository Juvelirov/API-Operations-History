package ru.netology.adenisov.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.netology.adenisov.domain.ConsolePrintable;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoanOperation extends Operation implements ConsolePrintable {
    private int loanId;

    public LoanOperation(int loanId) {
        this.loanId = loanId;
    }

    @Override
    public void printToConsole() {
        System.out.println("ID: " + loanId);
    }
}
