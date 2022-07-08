package com.senyakin.practice.model;

import java.util.Date;

public class Ticket {

    private Integer id;
    private Integer seat_number;
    private String name;
    private String departure_station_name;
    private String arrival_station_name;
    private String date;
    private Integer ticket_cost;
    private Integer numbered_seat_cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(Integer seat_number) {
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

    public void setId(String arrival_station_name) {
        this.arrival_station_name = arrival_station_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(Integer ticket_cost) {
        this.ticket_cost = ticket_cost;
    }

    public Integer getNumbered_seat_cost() {
        return numbered_seat_cost;
    }

    public void setNumbered_seat_cost(Integer numbered_seat_cost) {
        this.numbered_seat_cost = numbered_seat_cost;
    }

}
