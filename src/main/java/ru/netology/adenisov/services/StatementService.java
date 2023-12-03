package ru.netology.adenisov.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.adenisov.domain.Client;
import ru.netology.adenisov.domain.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class StatementService {
    private final Map<Integer, List<Operation>> storage = new HashMap<>();

    public void saveOperation(Operation operation, Client client) {
        List<Operation> operations = storage.get(client.getId());
        if (operations == null) {
            List<Operation> customerOperations = new ArrayList<>();
            customerOperations.add(operation);
            storage.put(client.getId(), customerOperations);
        } else {
            operations.add(operation);
        }
    }

    public Map<Integer, List<Operation>> getOperation() {
        return storage;
    }

    @PostConstruct
    public void init() {
        List<Operation> operations1 = new ArrayList<>();
        operations1.add(new Operation(1000, "RUB", "Coffee", 1));
        operations1.add(new Operation(300, "RUB", "Coffee", 2));
        storage.put(1, operations1);

        List<Operation> operations2 = new ArrayList<>();
        operations2.add(new Operation(1000, "USD", "Coffee", 1));
        operations2.add(new Operation(300, "USD", "Coffee", 2));
        operations2.add(new Operation(300, "USD", "Coffee", 3));
        storage.put(2, operations2);
    }
}
