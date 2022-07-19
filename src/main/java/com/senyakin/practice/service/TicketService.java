package com.senyakin.practice.service;

import com.senyakin.practice.model.Ticket;

import java.util.List;

public interface TicketService {

    void create(Ticket ticket);

    List<Ticket> readAll();

    Ticket read(int id);

    boolean delete(int id);

}
