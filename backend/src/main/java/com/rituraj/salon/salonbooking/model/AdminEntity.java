package com.rituraj.salon.salonbooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

import java.util.List;

@Document(collection = "Admin")
public class AdminEntity {

    @Id
    private String id;  // MongoDB will generate this automatically

    private String salonName;
    private String location;
  
    private String number;
    
   private List<Map<String, String>> services;
    private List<String> schedule;


    // Default constructor required by Spring
    public AdminEntity() {
    }

    // Parameterized constructor (without id, Mongo will generate it)
    public AdminEntity(String salonName, String location, String number, List<Map<String, String>> services,List <String> s) {
        this.salonName = salonName;
        this.location = location;
      
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
        return id;  
    }

    public void setId(String id) {
        this.id = id;  
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

   public String getLocation() {
    return location;
}

public void setLocation(String location) {
    this.location = location;
}


   

   

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Map<String, String>>  getServices() {
        return services;
    }

    public void setServices(List<Map<String, String>> services) {
        this.services = services;
    }
}
