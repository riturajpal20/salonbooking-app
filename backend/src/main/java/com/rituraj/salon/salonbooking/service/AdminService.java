package com.rituraj.salon.salonbooking.service;

import com.rituraj.salon.salonbooking.model.AdminEntity;
import com.rituraj.salon.salonbooking.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminEntity addSalon(AdminEntity adminEntity) {
        String num = adminEntity.getNumber();
        if (!num.startsWith("+91 ")) {
            throw new IllegalArgumentException("Number must start with '+91 '");
        }
      List<String> ss = adminEntity.getSchedule();
    List<String> newSchedule = new ArrayList<>();
    for (int i = 0; i < ss.size(); i++) {
        newSchedule.add(ss.get(i).trim());
    }
    adminEntity.setSchedule(newSchedule);
        String remaining = num.substring(4);
        if (remaining.length() != 10 || !remaining.matches("\\d{10}")) {
            throw new IllegalArgumentException("Number must be exactly 10 digits after '+91 '");
        }
        return adminRepository.save(adminEntity);
    }

    public List<AdminEntity> getAllSalons() {
        return adminRepository.findAll();
    }

    // Delete only one slot from salon schedule
    public boolean deleteSlot(String id, String slot) {
        AdminEntity salon = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salon not found"));

        List<String> schedule = salon.getSchedule();
        if (schedule != null && schedule.contains(slot)) {
            schedule.remove(slot);
            salon.setSchedule(schedule);
            adminRepository.save(salon);
            return true;
        }
        return false; // slot not found
    }

    // Delete entire salon
    public void deleteSalon(String id) {
        adminRepository.deleteById(id);
    }
}
