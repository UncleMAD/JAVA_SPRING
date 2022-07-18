package com.senyakin.practice.model;

import java.util.Date;

public class Ticket {

    private int id;
    private int seat_number;
    private String name;
    private String departure_station_name;
    private String arrival_station_name;
    private String date;
    private int ticket_cost;
    private int numbered_seat_cost;

    public Ticket(int id, int seat_number, String name, String departure_station_name, String arrival_station_name, String date, int ticket_cost, int numbered_seat_cost) {
        this.id = id;
        this.seat_number = seat_number;
        this.name = name;
        this.departure_station_name = departure_station_name;
        this.arrival_station_name = arrival_station_name;
        this.date = date;
        this.ticket_cost = ticket_cost;
        this.numbered_seat_cost = numbered_seat_cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparture_station_name() {
        return departure_station_name;
    }

    public void setDeparture_station_name(String departure_station_name) {
        this.departure_station_name = departure_station_name;
    }

    public String getArrival_station_name() {
        return arrival_station_name;
    }

    public void setArrival_station_name(String arrival_station_name) {
        this.arrival_station_name = arrival_station_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(int ticket_cost) {
        this.ticket_cost = ticket_cost;
    }

    public int getNumbered_seat_cost() {
        return numbered_seat_cost;
    }

    public void setNumbered_seat_cost(int numbered_seat_cost) {
        this.numbered_seat_cost = numbered_seat_cost;
    }
}
