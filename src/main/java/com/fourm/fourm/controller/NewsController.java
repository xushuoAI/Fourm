package com.fourm.fourm.controller;


import com.alibaba.fastjson.JSONObject;
import com.fourm.fourm.entity.Admin;
import com.fourm.fourm.entity.News;
import com.fourm.fourm.result.entity.ResultArticleJson;
import com.fourm.fourm.service.NewsService;

import com.fourm.fourm.util.HttpClient;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/News")
public class NewsController {
    @Autowired
    private NewsService newsService;

    //查看所有
    @GetMapping
    public ResultArticleJson showNewsList(Pageable pageable) {
        return  ResultArticleJson.suc(newsService.showAll(pageable));
    }
    @GetMapping("/{Id}")
    public ResultArticleJson showNewsById(@PathVariable("Id") Long id) {
        return  ResultArticleJson.suc(newsService.findNewsById(id));
    }

    @PostMapping
    public ResultArticleJson saveNews(@RequestBody News news,HttpSession session) {
        //news.getAdmin().setAdminId(news.getAuthorId());
        Object o= session.getAttribute("user");

        if (o!=null){
            news.setAdmin((Admin) o);
            //System.out.println(HttpClient.doPost(news.getNewsTitle()));
            JSONObject titleC=JSONObject.parseObject(HttpClient.doPost(news.getNewsTitle()));
            JSONObject contentC=JSONObject.parseObject(HttpClient.doPost(news.getNewsContent()));
            String title= (String) titleC.get("conclusion");
            String content= (String) contentC.get("conclusion");
            if (title.equals("合规")&&content.equals("合规")){
                newsService.saveNews(news);
                return ResultArticleJson.suc(newsService.saveNews(news));
            }else{
                return ResultArticleJson.fail(9011,"存在低俗辱骂不合规");
            }
        }else{
            return ResultArticleJson.fail(9001,"你还未登录");
        }

    }
    @RequestMapping(value = "/save/img", method = RequestMethod.POST)
    public String upload(@RequestParam("upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response){

        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString()+suffixName;
        //String uploadPath ="/home/forum/"+newFileName;
        String uploadPath ="E:/kankan/"+newFileName;
        File uploadPathFile = new File(uploadPath);
        if(!uploadPathFile.getParentFile().exists()){
            uploadPathFile.getParentFile().mkdirs();
        }

        //System.out.println("上传路径："+uploadPath);

        try {
            String realPath = "http://127.0.0.1:1525/forum/ForumArticleImages/"+newFileName;
            //String realPath = "http://111.229.39.131:1525/forum/ForumArticleImages/"+newFileName;
            file.transferTo(new File(uploadPath));
            return "{\"uploaded\":1, \"fileName\" : \"image.png\", \"url\":\""+realPath+"\"}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"uploaded\" : 1, \"fileName\" : \"image.png\", \"url\": , \"error\" : { \"message\":\"\" } }";
        }


    }
    @DeleteMapping("/{id}")
    public ResultArticleJson showNewsList(@PathVariable("id")Long id) {
        return  ResultArticleJson.suc(newsService.deleteNews(id));
    }


}
