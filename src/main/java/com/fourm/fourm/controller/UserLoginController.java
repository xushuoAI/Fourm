package com.fourm.fourm.controller;


import com.fourm.fourm.entity.Admin;
import com.fourm.fourm.result.entity.ResultArticleJson;
import com.fourm.fourm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/login")
public class UserLoginController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admin")
    public ResultArticleJson registerAdmin(@RequestBody Admin admin, HttpSession session){
        //存在这个用户
        if (adminService.existsAdmin(admin.getAdminName())){
            //密码正确
            if (adminService.existAccount(admin.getAdminName(),admin.getAdminPassword())){

                session.setAttribute("user",adminService.findByName(admin.getAdminName()));
                String sessId=session.getId();
                return ResultArticleJson.suc(sessId);
            }else{
                return ResultArticleJson.fail(9406,"密码错误");
            }
        }else{
            return ResultArticleJson.notFoundUser();
        }
    }

}
