package ru.netology.adenisov.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.adenisov.domain.Client;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerService {
    
    private final List<Client> storage = new ArrayList<>();

    public void addCustomer(int id, String name) {
        Client client = new Client(id, name);
        storage.add(client);
    }

    public List<Client> getCustomers() {
        return storage;
    }

    @PostConstruct
    public void init() {
        storage.add(new Client(1, "Artem Denisov"));
        storage.add(new Client(2, "Vasya Pupkin"));
    }
}
