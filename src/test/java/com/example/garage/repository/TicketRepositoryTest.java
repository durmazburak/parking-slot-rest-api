package com.example.garage.repository;

import com.example.garage.entity.Tickets;
import com.example.garage.enums.VehicleType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TicketRepositoryTest {

    @Autowired
    TicketsRepository repository;

    @Test
    public void testSaveRepository()
    {
        Tickets tickets = new Tickets();
        tickets.setTicketId(151L);
        tickets.setColor("Black");
        tickets.setVehiclePlate("34-HBO-2020");
        tickets.setVehicleType(VehicleType.Car);

        repository.save(tickets);

        Assert.assertNotNull(tickets.getColor());
    }

    @Test
    public void findAllBy() {
        List<Tickets> list = repository.findAllBy();
        Tickets tickets = new Tickets();
        tickets.setTicketId(5L);
        tickets.setColor("White");
        tickets.setVehiclePlate("34-LO-2000");
        tickets.setVehicleType(VehicleType.Car);
        list.add(tickets);
        assertNotNull(repository.findAllBy());
    }
}
