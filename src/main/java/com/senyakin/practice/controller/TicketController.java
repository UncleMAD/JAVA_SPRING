package com.senyakin.practice.controller;

import com.senyakin.practice.repository.TicketRepository;
import com.senyakin.practice.service.TicketService;
import com.senyakin.practice.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*rest controller - говорим стрингу что этот класс является  rest controller.
В этом классе будет реализована логика обработки запросов.
 */

@RestController
@RequestMapping("ticket")
public class TicketController {
    private final TicketService ticketService;

    /*
    сюда внедряем зависимость. в конструктор передаем интерфейс TicketService/
    */

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/add") /*создаем билет*/
    public ResponseEntity<?> create(@RequestBody Ticket ticket) {
        Ticket ts = ticketService.read(ticket.getId());
        if (ts != null) {
           return new ResponseEntity<>("ENTITY IS ALREADY EXISTS", HttpStatus.valueOf(205));
        }
                ticketService.create(ticket);
                return new ResponseEntity<>(HttpStatus.CREATED);

        }


    @GetMapping(value = "/read") //выводит все билеты
    public ResponseEntity<List<Ticket>> read() {
        final List<Ticket> ticket = ticketService.readAll();
        return ticket != null && !ticket.isEmpty()
                ? new ResponseEntity<>(ticket, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping(value = "/read/{id}") /*вытягивает билет по его айди*/
    public ResponseEntity<Ticket> read(@PathVariable(name = "id") int id) {
        final Ticket ticket = ticketService.read(id);

        return ticket != null
                ? new ResponseEntity<>(ticket, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/information")
    public String information() {
        return String.format("Проект разработан студентом группы УВА-211 Никитой Сенякиным. " +
                "Количество сущностей: %s", ticketService.readAll().size());
    }

    @DeleteMapping(value = "delete/{id}") //удаление по айдишнику
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        try {
            Ticket ts = ticketService.read(id);
        }
        catch (IllegalStateException e) {
            System.out.println("IllegalStateException : \n" + e.getMessage());
            return new ResponseEntity<>("TRY AGAIN NEXT TIME",HttpStatus.NOT_MODIFIED);
        }
        final boolean deleted = ticketService.delete(id);
        System.out.println("\n TEST:\n" + deleted );
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



}
