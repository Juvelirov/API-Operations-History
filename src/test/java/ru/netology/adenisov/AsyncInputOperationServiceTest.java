package ru.netology.adenisov;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.adenisov.OperationHistoryApiApplicationTest;
import ru.netology.adenisov.domain.Operation;
import ru.netology.adenisov.services.AsyncInputOperationService;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AsyncInputOperationServiceTest extends OperationHistoryApiApplicationTest {
    @Autowired
    AsyncInputOperationService asyncInputOperationService;

    @Test
    public void addOperationTest() {
        Operation operation = new Operation(1000, "RUB", "Место", 5);
        boolean operationOffer = asyncInputOperationService.addOperation(operation);
        assertTrue(operationOffer);
    }

    @Test
    public void startAsyncOperationProcessingTest() {
        asyncInputOperationService.startAsyncOperationProcessing();
    }
}