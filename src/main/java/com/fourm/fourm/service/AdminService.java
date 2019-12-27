package com.fourm.fourm.service;


import com.fourm.fourm.entity.Admin;
import com.fourm.fourm.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public Admin adminItem(Integer id) {
        return adminRepo.findByAdminId(id);
    }
    public Admin findByName(String name) {
        return adminRepo.findByAdminName(name);
    }
    public Admin addAdmin(Admin admin){ return adminRepo.saveAndFlush(admin);}
    public boolean existsUser(Integer id){
        return adminRepo.existsById(id);
    }

    public boolean existsAdmin(String adminName){
        return adminRepo.existsAdminByAdminName(adminName);
    }

    public  boolean existAccount(String name,String pwd){
        return adminRepo.existsAdminByAdminNameAndAdminPassword(name,pwd);

    }


}
