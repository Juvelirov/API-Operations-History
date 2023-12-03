package ru.netology.adenisov.controller.dto;

import lombok.Data;
import ru.netology.adenisov.controller.dto.OperationDTO;
import ru.netology.adenisov.domain.Operation;

import java.util.List;
import java.util.Map;

@Data
public class GetOperationResponse {
    private final List<OperationDTO> operations;
}
