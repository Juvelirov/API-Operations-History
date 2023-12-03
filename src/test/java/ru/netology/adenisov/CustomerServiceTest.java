package ru.netology.adenisov;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.adenisov.OperationHistoryApiApplicationTest;
import ru.netology.adenisov.domain.Client;
import ru.netology.adenisov.services.CustomerService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest extends OperationHistoryApiApplicationTest {
    @Autowired
    CustomerService customerService;

    @Test
    public void getCustomersTest() {
        List<Client> clients = customerService.getCustomers();
        Client client1 = clients.get(0);
        Client client2 = clients.get(1);
        assertEquals(1, client1.getId());
        assertEquals("Artem Denisov", client1.getName());
        assertEquals(2, client2.getId());
        assertEquals("Vasya Pupkin", client2.getName());
        assertEquals(2, clients.size());
    }

    @Test
    public void addCustomersTest() {
        customerService.addCustomer(3, "Baron");
        assertEquals(new Client(3, "Baron"), customerService.getCustomers().get(2));
    }
}
