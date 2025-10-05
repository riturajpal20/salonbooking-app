package com.rituraj.salon.salonbooking.controller;

import com.rituraj.salon.salonbooking.model.AdminEntity;
import com.rituraj.salon.salonbooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public AdminEntity addSalon(@RequestBody AdminEntity adminEntity) {
        return adminService.addSalon(adminEntity);
    }

    @GetMapping("/getall")
    public List<AdminEntity> getAllSalons() {
        return adminService.getAllSalons();
    }

    // Delete a single slot
    @DeleteMapping("/delete/{id}/{slot}")
    public ResponseEntity<String> deleteSlot(@PathVariable String id, @PathVariable String slot) {
        System.out.println("hi hi hi hi ");
        System.out.println(id);
         System.out.println(slot);

        boolean deleted = adminService.deleteSlot(id, slot);
        if (deleted) {
            return ResponseEntity.ok("Slot '" + slot + "' deleted successfully!");
        } else {
            return ResponseEntity.status(404).body("Slot not found");
        }
    }

    // Delete entire salon
    @DeleteMapping("/dlt/{id}")
    public String deleteSalon(@PathVariable String id) {
        adminService.deleteSalon(id);
        return "Salon deleted successfully!";
    }
}
