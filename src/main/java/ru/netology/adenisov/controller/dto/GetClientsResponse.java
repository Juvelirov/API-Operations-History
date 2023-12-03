package ru.netology.adenisov.controller.dto;

import lombok.Data;
import ru.netology.adenisov.controller.dto.ClientDTO;

import java.util.List;

@Data
public class GetClientsResponse {
    private final List<ClientDTO> clients;
}
