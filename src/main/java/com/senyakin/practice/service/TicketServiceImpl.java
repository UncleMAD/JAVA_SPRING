
package com.senyakin.practice.service;

import com.senyakin.practice.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TicketServiceImpl implements TicketService {

    private static final Map<Integer, Ticket> TICKET_REPOSITORY_MAP = new HashMap<>();

    private static final AtomicInteger TICKET_ID = new AtomicInteger();

    @Override
    public void create(Ticket ticket) {
        final int ticketId = TICKET_ID.incrementAndGet();
        ticket.setId(ticketId);
        TICKET_REPOSITORY_MAP.put(ticketId, ticket);
    }

    @Override
    public List<Ticket> readAll() {
        return new ArrayList<>(TICKET_REPOSITORY_MAP.values());
    }

    @Override
    public Ticket read(int id) {
        return TICKET_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Ticket ticket, int id) {
        if (TICKET_REPOSITORY_MAP.containsKey(id)) {
            ticket.setId(id);
            TICKET_REPOSITORY_MAP.put(id, ticket);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return TICKET_REPOSITORY_MAP.remove(id) != null;
    }
}
