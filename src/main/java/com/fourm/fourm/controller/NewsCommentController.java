package com.fourm.fourm.controller;


import com.fourm.fourm.entity.NewsComment;
import com.fourm.fourm.repository.NewsCommentRepo;
import com.fourm.fourm.result.entity.ResultArticleJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/newscomment")
public class NewsCommentController {

    @Autowired
    private NewsCommentRepo newsCommentRepo;


    @PostMapping("/save")
    public ResultArticleJson saveComment(@RequestBody NewsComment newsComment) {

        return ResultArticleJson.suc(newsCommentRepo.saveAndFlush(newsComment));

    }



}
