package com.rituraj.salon.salonbooking.service;

import com.rituraj.salon.salonbooking.model.AdminEntity;
import com.rituraj.salon.salonbooking.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminEntity addSalon(AdminEntity adminEntity) {
        String num = adminEntity.getNumber();

        if (!num.startsWith("+91 ")) {
            throw new IllegalArgumentException("Number must start with '+91 '");
        }

        String remaining = num.substring(4);

        if (remaining.length() != 10 || !remaining.matches("\\d{10}")) {
            throw new IllegalArgumentException("Number must be exactly 10 digits after '+91 '");
        }

        return adminRepository.save(adminEntity);
    }
    public List<AdminEntity> getsalon(){
        return adminRepository.findAll();
    }
   public void deleteSalon(String id, String slot) {
    // fetch entity from repo
    AdminEntity admin = adminRepository.findById(id)
                                       .orElseThrow(() -> new RuntimeException("Salon not found"));

    // get schedule safely
    List<String> schedule = admin.getSchedule();
    if (schedule != null) {
        schedule.remove(slot);
    }

    // check if schedule is now empty
    if (schedule == null || schedule.isEmpty()) {
        adminRepository.deleteById(id);
    } else {
        adminRepository.save(admin); // update modified entity
    }
   
    }
     public void dltsalon(String id){
        adminRepository.deleteById(id);


    }

}
