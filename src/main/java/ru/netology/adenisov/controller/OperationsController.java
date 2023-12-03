package ru.netology.adenisov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.adenisov.controller.dto.ClientDTO;
import ru.netology.adenisov.controller.dto.GetClientsResponse;
import ru.netology.adenisov.controller.dto.GetOperationResponse;
import ru.netology.adenisov.controller.dto.OperationDTO;
import ru.netology.adenisov.domain.Client;
import ru.netology.adenisov.domain.Operation;
import ru.netology.adenisov.services.AsyncInputOperationService;
import ru.netology.adenisov.services.CustomerService;
import ru.netology.adenisov.services.StatementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/operations/")
@RequiredArgsConstructor
public class OperationsController {
    private final AsyncInputOperationService operationService;
    private final StatementService statementService;
    private final CustomerService customerService;

    @GetMapping(path = "/{clientId}")
    public List<Operation> getOperation(@PathVariable int clientId) {
        Map<Integer, List<Operation>> clientOperations = statementService.getOperation();
        return clientOperations.get(clientId);
    }

    @PostMapping(path = "/{clientId}")
    @ResponseStatus(HttpStatus.CREATED)
    public String setOperation(@RequestBody OperationDTO operation, @PathVariable int clientId) {
        for (Client client : customerService.getCustomers()) {
            if (client.getId() == clientId) {
                statementService.saveOperation(new Operation(operation.getSum(),
                                operation.getCurrency(),
                                operation.getMerchant(),
                                operation.getId()),
                        client);
                operationService.addOperation(new Operation(operation.getSum(),
                        operation.getCurrency(),
                        operation.getMerchant(),
                        operation.getId()));

                return "Success";
            }
        }

        return "Failed";
    }

    @DeleteMapping(path = "/{clientId}/{operationId}")
    public GetOperationResponse deleteOperation(@PathVariable int clientId, @PathVariable int operationId) {
        List<Operation> operations = statementService.getOperation().get(clientId);
        operations.removeIf(operation -> operation.getId() == operationId);
        List<OperationDTO> operationDTOS = operations.stream()
                .map(operation -> new OperationDTO(operation.getId(),
                        operation.getSum(),
                        operation.getCurrency(),
                        operation.getMerchant()))
                .toList();
        return new GetOperationResponse(operationDTOS);
    }
}
