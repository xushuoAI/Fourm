package com.fourm.fourm.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "forum_Manager_Account")
@Data
public class ManagerAccount {
    //能获取接口信息的管理人员

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer accountId;
    @Column(length = 50)
    private String accountName;
    @Column(length = 50)
    private String accountPwd;

    private String accountDes;//描述






}
