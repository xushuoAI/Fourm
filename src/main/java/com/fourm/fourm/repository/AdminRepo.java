package com.fourm.fourm.repository;

import com.fourm.fourm.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo  extends JpaRepository<Admin,Integer> {

    Admin findByAdminId(Integer id);
    Admin findByAdminName(String name);

    boolean existsAdminByAdminName(String name);

    boolean existsAdminByAdminNameAndAdminPassword(String name,String password);
}
