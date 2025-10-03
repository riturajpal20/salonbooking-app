package com.rituraj.salon.salonbooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Admin")
public class AdminEntity {

    @Id
    private String id;  // MongoDB will generate this automatically

    private String salonName;
    private String locality;
    private int price;
    private String number;
    private int time ;
    private List<String> services;
    private List<String> schedule;


    // Default constructor required by Spring
    public AdminEntity() {
    }

    // Parameterized constructor (without id, Mongo will generate it)
    public AdminEntity(String salonName, String locality, int price, String number, List<String> services,List <String> s) {
        this.salonName = salonName;
        this.locality = locality;
        this.price = price;
        this.number = number;
        this.services = services;
        this.schedule=s;
    }
    // set schedule 
    public List<String> getSchedule(){
        return schedule;
    }
    public void setSchedule(List <String> s){
        this.schedule=s;

    }



    // Getters and Setters

    public String getId() {
        return id;  // Include getter for frontend to use ID
    }

    public void setId(String id) {
        this.id = id;  // Usually not needed; Mongo sets it automatically
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
}
