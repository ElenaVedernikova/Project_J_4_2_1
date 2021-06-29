package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket ticketMoFr1 = new Ticket(1, 5500, "MOW", "FRU", 90);
    private Ticket ticketLeGo = new Ticket(2, 1000, "LED", "GOJ", 30);
    private Ticket ticketGoLe = new Ticket(3, 1000, "GOJ", "LED", 40);
    private Ticket ticketKuFr = new Ticket(4, 1000, "KUF", "FRU", 50);
    private Ticket ticketZkKu2 = new Ticket(5, 1100, "ZKD", "KUF", 60);
    private Ticket ticketMoFr2 = new Ticket(6, 2500, "MOW", "FRU", 80);
    private Ticket ticketZkKu1 = new Ticket(7, 1700, "ZKD", "KUF", 60);
    private Ticket ticketKuLe = new Ticket(8, 1700, "KUF", "LED", 90);
    private Ticket ticketMoFr3 = new Ticket(9, 3500, "MOW", "FRU", 70);
    private Ticket ticketMoFr4 = new Ticket(10, 4500, "MOW", "FRU", 60);


    @Test
    public void shouldFindByDifferentTime() {
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

        Ticket[] expected = new Ticket[]{ticketMoFr4, ticketMoFr3, ticketMoFr2, ticketMoFr1};
        Ticket[] actual = manager.findAll("MOW", "FRU", new TicketByPriceAscComparator());

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindBySameTime() {
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

        Ticket[] expected = new Ticket[]{ticketZkKu2, ticketZkKu1};
        Ticket[] actual = manager.findAll("ZKD", "KUF", new TicketByPriceAscComparator());

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByTime() {
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

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("ZKD", "FRU", new TicketByPriceAscComparator());

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByPrice() {
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

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("ZKD", "MOW");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}