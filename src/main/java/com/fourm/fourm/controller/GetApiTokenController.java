package com.fourm.fourm.controller;


import com.fourm.fourm.service.TokenService;
import com.fourm.fourm.util.JwtUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/getToken")
public class GetApiTokenController {
    @Autowired
    private TokenService tokenService;
    @PostMapping("/apitoken")
    public String getToken(@RequestBody Map map)   {
        String tokenJson;
        if (map.isEmpty()){
            tokenJson="{\"token\":\"传输数据为空\"}";
        }else{
            Object gname=map.get("name");
            Object gpwd=map.get("pwd");
            String name=(String)gname;
            String pwd=(String)gpwd;
            if (tokenService.existAccount(name,pwd)){
                String jwtToken= JwtUtil.generateToken(name,pwd);
                tokenJson="{\"token\":\""+jwtToken+"\"}";
            }else{
                tokenJson="{\"token\":\"无效的用户\"}";
            }
        }
        return tokenJson;
    }
    @RequestMapping("/body")
    public void testRequestBody(@RequestBody Map map) {
        System.out.println(map);
        System.out.println(map.get("name"));
    }
}

