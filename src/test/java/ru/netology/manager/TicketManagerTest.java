package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket ticketMoFr1 = new Ticket(1, 2500, "MOW", "FRU", 90);
    private Ticket ticketLeGo = new Ticket(2, 1000, "LED", "GOJ", 30);
    private Ticket ticketGoLe = new Ticket(3, 1000, "GOJ", "LED", 40);
    private Ticket ticketKuFr = new Ticket(4, 1000, "KUF", "FRU", 50);
    private Ticket ticketZkKu2 = new Ticket(5, 1700, "ZKD", "KUF", 60);
    private Ticket ticketMoFr2 = new Ticket(6, 2000, "MOW", "FRU", 90);
    private Ticket ticketZkKu1 = new Ticket(7, 1700, "ZKD", "KUF", 60);
    private Ticket ticketKuLe = new Ticket(8, 1700, "KUF", "LED", 90);
    private Ticket ticketMoFr3 = new Ticket(9, 4000, "MOW", "FRU", 90);
    private Ticket ticketMoFr4 = new Ticket(10, 3000, "MOW", "FRU", 90);


    @Test
    public void shouldFindByDifferentPrice() {
        manager.add(ticketMoFr1);
        manager.add(ticketLeGo);
        manager.add(ticketGoLe);
        manager.add(ticketKuFr);
        manager.add(ticketZkKu2);
        manager.add(ticketMoFr2);
        manager.add(ticketZkKu1);
        manager.add(ticketKuLe);
        manager.add(ticketMoFr3);
        manager.add(ticketMoFr4);

        Ticket[] expected = new Ticket[]{ticketMoFr2, ticketMoFr1, ticketMoFr4, ticketMoFr3};
        Ticket[] actual = manager.findAll("MOW", "FRU");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

   
}