package com.rituraj.salon.salonbooking.controller;

import com.rituraj.salon.salonbooking.model.AdminEntity;
import com.rituraj.salon.salonbooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/admin")
// @CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public AdminEntity add_Salon(@RequestBody AdminEntity adminEntity) {
        return adminService.addSalon(adminEntity);
    }
    @GetMapping("/getall")
        public List<AdminEntity> get_salon(){
            return adminService.getsalon();
    }
    @DeleteMapping("/delete/{id}/{slot}")
    public String deleteSalon(@PathVariable String id,@PathVariable String slot) {
        adminService.deleteSalon(id,slot);
        return "Salon with id " + id + " deleted successfully!";
    }
      @DeleteMapping("/dlt/{id}")
    public String dltSalon(@PathVariable String id) {
        adminService.dltsalon(id);
        return "Salon with id " + id + " deleted successfully!";
    }
    
}
