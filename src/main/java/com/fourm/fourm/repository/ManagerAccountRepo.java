package com.fourm.fourm.repository;


import com.fourm.fourm.entity.ManagerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerAccountRepo extends JpaRepository<ManagerAccount,Integer> {

    boolean existsByAccountNameAndAccountPwd(String accountName,String accountPwd);
}
