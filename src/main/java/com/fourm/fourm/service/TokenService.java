package com.fourm.fourm.service;

import com.fourm.fourm.repository.ManagerAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    private ManagerAccountRepo managerAccountRepo;

    public  boolean existAccount(String name,String pwd){
        return managerAccountRepo.existsByAccountNameAndAccountPwd(name,pwd);

    }
}
