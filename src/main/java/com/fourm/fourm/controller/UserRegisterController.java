package com.fourm.fourm.controller;

import com.fourm.fourm.entity.Admin;
import com.fourm.fourm.result.entity.ResultArticleJson;
import com.fourm.fourm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserRegisterController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admin")
    public ResultArticleJson registerAdmin(@RequestBody Admin admin){
        if (adminService.existsAdmin(admin.getAdminName())){
            return ResultArticleJson.fail(9001,"用户名已经存在");
        }else{
            return ResultArticleJson.suc(adminService.addAdmin(admin));
        }

    }


}
