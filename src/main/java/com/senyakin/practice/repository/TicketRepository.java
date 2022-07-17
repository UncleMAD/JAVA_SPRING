package com.senyakin.practice.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senyakin.practice.model.Ticket;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class TicketRepository {
    private final String PATH_TO_FILE = "src/main/resources/data.json";

    /*metodi*/
    public List<Ticket> readFile(){//считываем
        try {
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(PATH_TO_FILE));//создаем переменную обращаемся к файлу который будем считывать
            // convert JSON array to list of users
            List<Ticket> tickets = new Gson().fromJson(reader, new TypeToken<List<Ticket>>() {}.getType());//это массив. сюда в эту переменную мы будем сохраянть все данные из джсон
            reader.close();
            return tickets;

        } catch (Exception ex) {//исключение
            ex.printStackTrace();
        }
        throw new RuntimeException();
    }
    public void addtoFile (List<Ticket> ticket) { //Добавление в файл
        String jsonstring;
        try {
            Gson gson = new Gson();
            jsonstring = gson.toJson(ticket);//переменная преобразованная в json
            try (PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE)))//показываем куда записывать по какому адресу
            {
                out.write(jsonstring);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void save(Ticket ticket) { //сохранение
        List<Ticket> tickets = readFile();
        tickets.add(ticket);//эдд есть у класса лист
        addtoFile(tickets);
    }
    public boolean selectExistTicketById(int id){ //проверить наличие город по айдишнику
        final List<Ticket> all = readFile();
        for (Ticket ticket: all) {
            if (ticket.getId() == id) return true;
        }
        return false;
    }

    public Boolean deleteTicketById(int id){
        List<Ticket> tickets = readFile().stream().filter(ticket -> ticket.getId() != id).collect(Collectors.toList());

        addtoFile(tickets);
        return true;
    }


    public Ticket getById(int id){ //получаем по айдишнику
        final List<Ticket> all = readFile();
        for (Ticket ticket: all) {
            if (ticket.getId() == id) return ticket;
        }
        throw new IllegalStateException("НЕВОЗМОЖНО");
    }
}


