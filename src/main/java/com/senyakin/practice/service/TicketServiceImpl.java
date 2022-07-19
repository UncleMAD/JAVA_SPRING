package com.senyakin.practice.service;

import com.senyakin.practice.model.Ticket;
import com.senyakin.practice.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void create(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> readAll() {
        return ticketRepository.readFile();
    }

    @Override
    public Ticket read(int id) {
        return ticketRepository.getById(id);
    }


    @Override
    public boolean delete(int id) {
        ticketRepository.deleteTicketById(id);
        return true;
    }
}
